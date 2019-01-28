package cn.huangxulin.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@SpringBootApplication
@MapperScan("cn.huangxulin.cloud.mapper")
@EnableEurekaClient
public class A003ProviderUser {

    public static void main(String[] args) {
        SpringApplication.run(A003ProviderUser.class, args);
    }
}
