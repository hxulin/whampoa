package cn.huangxulin.rabbitmq._06_confirm._01_general_confirm;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 普通的Confirm模式
 *
 * 每发送一条消息后，调用waitForConfirms()方法，等待服务器端confirm。实际上是一种串行confirm了。
 */
public class SendConfirm {

    private static final String QUEUE_NAME = "confirm_queue";

    public static void main(String[] args) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 生产者通过调用channel的confirmSelect方法将channel设置为confirm模式
        channel.confirmSelect();
        String msg = "Hello QUEUE!";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("utf-8"));
        if (!channel.waitForConfirms()) {
            System.out.println("send message 失败");
        } else {
            System.out.println(" send messgae ok ...");
        }
        channel.close();
        connection.close();
    }

}
