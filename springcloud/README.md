## SpringCloud练习

### 1、springcloud-a001-eureka-server

初识 Eureka Server，在 Spring Boot 环境下使用 **@EnableEurekaServer** 注解启动 Eureka Server 服务

### 2、springcloud-a002-provider-user、springcloud-a002-consumer-movie

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

**数据库使用的是 H2，持久层框架使用的是 MyBatisPlus**

### 3、springcloud-a003

| springcloud-a003-parent         | Maven 父项目，抽取公共依赖 |
| ------------------------------- | -------------------------- |
| springcloud-a003-eureka-server  | Eureka 服务注册中心        |
| springcloud-a003-provider-user  | 用户微服务，服务提供者     |
| springcloud-a003-consumer-movie | 电影微服务，服务消费者     |

#### 将用户和电影微服务注册到 Eureka

**（1）添加依赖**

```html
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
    <version>1.4.4.RELEASE</version>
</dependency>
```

**（2）在 SpringBoot 启动方法上添加注解 `@EnableEurekaClient`**

```java
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**（3）配置文件**

```yaml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/		# Eureka Server 地址
  instance:
    instance-id: ${spring.application.name}:${spring.application.instance_id:${server.port}}	# 实例名称的显示格式（应用名称：端口号） 
    prefer-ip-address: true		# 允许通过 IP 访问，默认是通过主机名访问
```

#### 获取服务地址、实例信息

```java
@Autowired
private EurekaClient eurekaClient;

@Autowired
private DiscoveryClient discoveryClient;

@GetMapping("/eureka-instance")
public String serviceUrl() {
    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SPRINGCLOUD-A003-PROVIDER-USER", false);
    return instance.getHomePageUrl();
}

@GetMapping("/instance-info")
public ServiceInstance showInfo() {
    List<ServiceInstance> list = discoveryClient.getInstances("SPRINGCLOUD-A003-PROVIDER-USER");
    if (list != null && list.size() > 0 ) {
        return list.get(0);
    }
    return null;
}
```

#### 健康检查

添加依赖：

```html
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

健康检查配置：

```yaml
eureka:
  client:
    healthcheck:
      enabled: true		# 开启健康检查
```




