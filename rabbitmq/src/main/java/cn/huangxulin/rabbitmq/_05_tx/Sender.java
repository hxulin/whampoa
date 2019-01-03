package cn.huangxulin.rabbitmq._05_tx;

import cn.huangxulin.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * 事务
 */
public class Sender {

    private static final String QUEUE_NAME = "tx_queue_01";

    public static void main(String[] args) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String msg = "Hello Simple QUEUE !";
        try {
            channel.txSelect();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            // 模拟异常
            int result = 1 / 0;
            channel.txCommit();
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("----msg rollabck ");
        } finally {
            channel.close();
            connection.close();
        }
    }

}
