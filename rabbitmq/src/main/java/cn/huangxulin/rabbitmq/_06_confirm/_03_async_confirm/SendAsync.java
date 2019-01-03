package cn.huangxulin.rabbitmq._06_confirm._03_async_confirm;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 异步confirm模式
 * <p>
 * Channel对象提供的ConfirmListener()回调方法只包含deliveryTag（当前Chanel发出的消息序号），
 * 我们需要自己为每一个Channel维护一个unconfirm的消息序号集合，每publish一条数据，集合中元素加1，
 * 每回调一次handleAck方法，unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。
 * 从程序运行效率上看，这个unconfirm集合最好采用有序集合SortedSet存储结构。
 * 实际上，SDK中的waitForConfirms()方法也是通过SortedSet维护消息序号的。
 */
public class SendAsync {

    private static final String QUEUE_NAME = "async_confirm_queue";

    public static void main(String[] args) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 生产者通过调用channel的confirmSelect方法将channel设置为confirm模式
        channel.confirmSelect();
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<>());
        channel.addConfirmListener(new ConfirmListener() {
            // 每回调一次handleAck方法，unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。
            public void handleAck(long deliveryTag, boolean multiple) {
                if (multiple) {
                    System.out.println("--multiple--");
                    confirmSet.headSet(deliveryTag + 1).clear();
                    //用一个SortedSet, 返回此有序集合中小于end的所有元素。
                } else {
                    System.out.println("--multiple false--");
                    confirmSet.remove(deliveryTag);
                }
            }

            public void handleNack(long deliveryTag, boolean multiple) {
                System.out.println("Nack, SeqNo: " + deliveryTag + ", multiple: " + multiple);
                if (multiple) {
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    confirmSet.remove(deliveryTag);
                }
            }
        });
        String msg = "Hello QUEUE!";
        while (true) {
            long nextSeqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("utf-8"));
            confirmSet.add(nextSeqNo);
        }
    }

}
