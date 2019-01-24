package cn.huangxulin.spring._04_bean_life_cycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述: 测试 Spring Bean 的生命周期
 *
 * @author hxulin
 */
public class BeanLifeCycleTest {

    @Test
    void testBeanLifeCycle() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/huangxulin/spring/_04_bean_life_cycle/BeanLifeCycleTest-context.xml");
        JuiceMaker2 juiceMaker2 = ctx.getBean("juiceMaker2", JuiceMaker2.class);
        System.out.println(juiceMaker2.makeJuice());
        ctx.close();  // ClassPathXmlApplicationContext 的父类 AbstractApplicationContext 中有 close 方法
    }
}
