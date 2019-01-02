package cn.huangxulin.rabbitmq._03_publish_subscribe;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 发布、订阅模式
 */
public class Sender {

    //交换机名称
    private final static String EXCHANGE_NAME = "my_exchange_fanout";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明一个交换机，一个参数为交换机名称，第二个参数为模式
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); // fanout 分裂
        // 消息内容
        String message = "hello rabbitMQ!";
        //发送消息
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("utf-8"));
        System.out.println("Send '" + message + "'");
        channel.close();
        connection.close();
    }

}
