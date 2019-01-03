package cn.huangxulin.rabbitmq._06_confirm._02_batch_confirm;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 批量Confirm模式
 * <p>
 * 每发送一批消息后，调用waitForConfirms()方法，等待服务器端confirm。
 * <p>
 * 批量confirm模式稍微复杂一点，客户端程序需要定期（每隔多少秒）或者定量（达到多少条）或者两则结合起来publish消息，
 * 然后等待服务器端confirm, 相比普通confirm模式，批量极大提升confirm效率，
 * 但是问题在于一旦出现confirm返回false或者超时的情况时，客户端需要将这一批次的消息全部重发，
 * 这会带来明显的重复消息数量，并且，当消息经常丢失时，批量confirm性能应该是不升反降的。
 */
public class SendBatchConfirm {

    private static final String QUEUE_NAME = "confirm_queue";

    public static void main(String[] args) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //生产者通过调用channel的confirmSelect方法将channel设置为confirm模式
        channel.confirmSelect();

        String msg = "Hello QUEUE!";
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("utf-8"));
        }

        if (!channel.waitForConfirms()) {
            System.out.println("send message error");
        } else {
            System.out.println(" send messgae ok ...");
        }
        channel.close();
        connection.close();
    }

}
