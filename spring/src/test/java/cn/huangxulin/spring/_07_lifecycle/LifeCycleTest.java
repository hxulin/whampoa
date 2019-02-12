package cn.huangxulin.spring._07_lifecycle;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class LifeCycleTest {

    @Test
    void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/_07_lifecycle/AppTest-context.xml");
        MyDataSource dataSource = ctx.getBean("dataSource", MyDataSource.class);
        dataSource.doWork();
        ctx.close();
    }

    @Test
    void test2() {
        @Cleanup
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/_07_lifecycle/AppTest-context.xml");
        MyDataSource dataSource = ctx.getBean("dataSource", MyDataSource.class);
        dataSource.doWork();
    }

    @Test
    void test3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/_07_lifecycle/AppTest-context.xml");
        MyDataSource dataSource = ctx.getBean("dataSource", MyDataSource.class);
        dataSource.doWork();
        ctx.registerShutdownHook();
    }
}
