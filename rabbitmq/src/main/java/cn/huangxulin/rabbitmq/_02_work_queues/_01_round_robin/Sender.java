package cn.huangxulin.rabbitmq._02_work_queues._01_round_robin;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 工作队列 - 轮询分发
 */
public class Sender {

    private static final String QUEUE_NAME = "work_queue_01";

    public static void main(String[] args) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "." + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }
}
