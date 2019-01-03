package cn.huangxulin.rabbitmq._04_routing;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 */
public class Receiver2 {

    //队列名称
    private final static String QUEUE_NAME = "my_queue_direct_02";
    //交换机名称
    private final static String EXCHANGE_NAME = "my_exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "warning");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "error");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "info");
        // ------------下面逻辑和work模式一样-----
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 消息到达 触发这个方法
                String msg = new String(body, "utf-8");
                System.out.println("[info]:" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("info消息执行完毕！");
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);

    }

}
