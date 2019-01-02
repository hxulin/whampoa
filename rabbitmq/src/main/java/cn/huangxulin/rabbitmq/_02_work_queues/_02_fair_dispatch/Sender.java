package cn.huangxulin.rabbitmq._02_work_queues._02_fair_dispatch;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 工作队列 - 公平分发
 */
public class Sender {

    private static final String QUEUE_NAME = "work_queue_01";

    private static Integer prefetchCount = 1;

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        // 每个消费者发送确认信号之前，消息队列不发送下一个消息过来，一次只处理一个消息
        // 限制发给同一个消费者不得超过1条消息
        channel.basicQos(prefetchCount);

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "." + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }

}
