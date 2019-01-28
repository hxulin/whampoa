package cn.huangxulin.cloud.controller;

import cn.huangxulin.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {

        // http://localhost:7900/user/  =>  http://springcloud-a003-provider-user/user/

        // VIP: virtual IP

        // 服务提供者的 ServiceId, 即服务提供者的 spring.application.name

        return restTemplate.getForObject("http://springcloud-a003-provider-user/user/" + id, User.class);
    }
}
