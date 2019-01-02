package cn.huangxulin.rabbitmq._01_hello;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    private static final String QUEUE_NAME = "hello_01";

    public static void main(String[] args) throws IOException, TimeoutException {

        String message = "hello word! 你好，世界！";
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建通道，为了发送消息，你必须要声明一个消息队列，然后向该队列里推送消息
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送消息
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));

        channel.close();

        connection.close();
    }
}
