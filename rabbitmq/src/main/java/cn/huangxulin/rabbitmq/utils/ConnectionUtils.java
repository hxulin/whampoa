package cn.huangxulin.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    /**
     * 获取connection
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //创建connection工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置ip
        factory.setHost("192.168.202.130");
        //设置端口号
        factory.setPort(5672);
        //设置用户名称
        factory.setUsername("admin");
        //设置密码
        factory.setPassword("12345678");
        //设置vhost
        factory.setVirtualHost("test");
        return factory.newConnection();
    }
}
