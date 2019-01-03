package cn.huangxulin.rabbitmq._05_tx;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 事务
 */
@SuppressWarnings("all")
public class Receiver {

    private static final String QUEUE_NAME = "tx_queue_01";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

}
