package cn.huangxulin.rabbitmq._02_work_queues._01_round_robin;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列 - 轮询分发
 */
public class Receiver2 {

    private static final String QUEUE_NAME = "work_queue_01";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //定义一个消息的消费者
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [2] 消费消息: '" + message + "'");
                try {
                    doWork(message);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [2] 消费消息结束");
                }
            }
        };
        boolean autoAck = true;
        //消息的确认模式自动应答
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }


    private static void doWork(String task) throws InterruptedException {
        Thread.sleep(2000);
    }

}
