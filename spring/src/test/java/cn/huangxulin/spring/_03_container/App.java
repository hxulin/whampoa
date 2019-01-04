package cn.huangxulin.spring._03_container;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class App {

    // 使用BeanFactory
    // BeanFactory有延迟初始化（懒：lazy）的特点，创建Spring容器的时候，不会立马去创建容器中管理的Bean对象
    // 而是要等到从容器中去获取对象的时候，才去创建对象
    /*

     -------------------------
     构建 Person ...
     cn.huangxulin.spring._03_container.Person@6591f517

     */
    @Test
    void testBeanFactory() {
        Resource resource = new ClassPathResource("cn/huangxulin/spring/_03_container/container.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("-------------------------");
        Person p = factory.getBean("person", Person.class);
        System.out.println(p);
    }

    // 使用ApplicationContext
    // 在创建Spring容器的时候，就会把容器中管理的Bean立即初始化，而不会等到获取Bean的时候才去初始化
    /*

     构建 Person ...
     -------------------------
     cn.huangxulin.spring._03_container.Person@161479c6

     */
    @Test
    void testApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/_03_container/container.xml");
        System.out.println("-------------------------");
        Person p = ctx.getBean("person", Person.class);
        System.out.println(p);
    }

}
