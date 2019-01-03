package cn.huangxulin.rabbitmq._04_routing;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 路由模式
 */
public class Sender {

    //交换机名称
    private final static String EXCHANGE_NAME = "my_exchange_direct";

    public static void main(String[] args) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 声明一个交换机，一个参数为交换机名称，第二个参数为模式
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        // 消息内容
        String message = "id=1的商品删除了";

        channel.basicPublish(EXCHANGE_NAME, "info", null, message.getBytes("utf-8"));
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
