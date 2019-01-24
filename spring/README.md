## Spring练习

### 1、Hello World

- 传统方式创建对象，组装依赖关系

- 使用Spring的BeanFactory获取对象

- 模拟Spring容器创建对象（反射 + 内省机制）

- 使用 **import** 导入其他配置文件：

  ```html
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
                             http://www.springframework.org/schema/beans/spring-beans.xsd">
      <import resource="classpath:cn/huangxulin/spring/hello.xml"/>
  </beans>
  ```

### 2、Spring测试

- JUnit4测试

```java
// 运行Spring的JUnit4
@RunWith(SpringJUnit4ClassRunner.class)

// 上下文配置对象（配置文件）
// @ContextConfiguration("classpath:cn/huangxulin/spring/springTest.xml")

// ContextConfiguration 注解后的参数可以省略
// 		1) 此时配置文件应和测试类放在同一目录
//      2) 配置文件名为：测试类名-context.xml
// SpringTest-context.xml
@ContextConfiguration
public class SpringTest {
    
}
```

- JUnit5测试

```java
// 1) 配置文件和测试类放在同一目录
// 2) 配置文件名为：测试类名-context.xml
// SpringJUnit5Test-context.xml
@SpringJUnitConfig
public class SpringJUnit5Test {
    
}
```

### 3、BeanFactory 和 ApplicationContext

- **BeanFactory**

```java
Resource resource = new ClassPathResource("cn/huangxulin/spring/container.xml");
BeanFactory factory = new XmlBeanFactory(resource);
System.out.println("-------------------------");
Person p = factory.getBean("person", Person.class);
System.out.println(p);
```

输出：

```
-------------------------
构建 Person ...
cn.huangxulin.spring.Person@6591f517
```

BeanFactory有延迟初始化（懒：lazy）的特点，创建Spring容器的时候，不会立马去创建容器中管理的Bean对象，而是要等到从容器中去获取对象的时候，才去创建对象。

- **ApplicationContext**

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/container.xml");
System.out.println("-------------------------");
Person p = ctx.getBean("person", Person.class);
System.out.println(p);
```

输出：

```
构建 Person ...
-------------------------
cn.huangxulin.spring.Person@161479c6
```

使用ApplicationContext创建Spring容器的时候，会把容器中管理的Bean立即初始化，而不会等到获取Bean的时候才去初始化。

> 是否延迟初始化可以在配置文件中进行配置（lazy-init）
>
> ```html
> <bean id="person" class="cn.huangxulin.spring.Person" lazy-init="default" />
> ```
> 全局配置（default-lazy-init）
>
> ```html
> <beans xmlns="http://www.springframework.org/schema/beans"
>        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>        xsi:schemaLocation="http://www.springframework.org/schema/beans
>                            http://www.springframework.org/schema/beans/spring-beans.xsd"
>        default-lazy-init="true">
> </beans>
> ```

### 4、Spring Bean 的生命周期

![bean-life-cycle.png](./bean-life-cycle.png)

```java
@Data
public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beverageShop;

    private Source source;

    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public void myDestroy() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    public String makeJuice() {
        return "这是一杯由" + beverageShop + "饮品店, 提供的" + source.getSize() + source.getSugar() + source.getFruit();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 BeanNameAware 接口的 setBeanName 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 BeanFactoryAware 接口的 setBeanFactory 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 ApplicationContextAware 接口的 setApplicationContext 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 InitializingBean 接口的 afterPropertiesSet 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用接口 DisposableBean 的 destroy 方法");
    }

}
```

```
【Source】对象source开始实例化
【Source】对象source实例化完成
【JuiceMaker2】调用 BeanNameAware 接口的 setBeanName 方法
【JuiceMaker2】调用 BeanFactoryAware 接口的 setBeanFactory 方法
【JuiceMaker2】调用 ApplicationContextAware 接口的 setApplicationContext 方法
【JuiceMaker2】对象juiceMaker2开始实例化
【JuiceMaker2】调用 InitializingBean 接口的 afterPropertiesSet 方法
【JuiceMaker2】执行自定义初始化方法
【JuiceMaker2】对象juiceMaker2实例化完成
这是一杯由贡茶饮品店, 提供的大杯少糖橙汁
【JuiceMaker2】调用接口 DisposableBean 的 destroy 方法
【JuiceMaker2】执行自定义销毁方法
```







