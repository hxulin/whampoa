## SpringCloud练习

#### 1、springcloud-a001-eureka-server

初识 Eureka Server，在 Spring Boot 环境下使用 **@EnableEurekaServer** 注解启动 Eureka Server 服务

#### 2、springcloud-a002-provider-user、springcloud-a002-consumer-movie

基于 **RestTemplate** 实现的简单的服务生产者和服务消费者的案例：电影微服务调用用户微服务

用户微服务代码：

```java
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userMapper.selectById(id);
    }
}
```

电影微服务代码：

```java
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:7900/user/" + id, User.class);
    }
}
```

**数据库使用的是 H2，持久层使用的是 MyBatisPlus**




