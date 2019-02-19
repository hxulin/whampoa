package cn.huangxulin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class A009ConsumerMovie {

    public static void main(String[] args) {
        SpringApplication.run(A009ConsumerMovie.class, args);
    }

}

