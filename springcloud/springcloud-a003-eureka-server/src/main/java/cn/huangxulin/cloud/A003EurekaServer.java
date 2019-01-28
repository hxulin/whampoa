package cn.huangxulin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer  // 启动服务注册中心，提供给其他应用程序进行对话
@SpringBootApplication
public class A003EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(A003EurekaServer.class, args);
    }

}

