package cn.huangxulin.rabbitmq2.utils;

import com.rabbitmq.client.ConnectionFactory;

/**
 * 功能描述: 初始化连接工厂
 *
 * @author hxulin
 */
public final class ConnectionFactoryUtils {

    private static final ConnectionFactory CONNECTION_FACTORY = new ConnectionFactory();

    static {
        // 设置RabbitMQ服务地址
        CONNECTION_FACTORY.setHost("192.168.202.130");

        // 设置用户名和密码
        CONNECTION_FACTORY.setUsername("admin");
        CONNECTION_FACTORY.setPassword("12345678");

        //设置虚拟机vhost
        CONNECTION_FACTORY.setVirtualHost("test");
    }

    private ConnectionFactoryUtils() {

    }

    public static ConnectionFactory getConnectionFactory() {
        return CONNECTION_FACTORY;
    }
}
