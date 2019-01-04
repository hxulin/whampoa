package cn.huangxulin.spring._02_spring_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述: SpringTest案例测试
 *
 * @author hxulin
 */

// 运行Spring的JUnit4
@RunWith(SpringJUnit4ClassRunner.class)

// 上下文配置对象（寻找配置文件）
//@ContextConfiguration("classpath:cn/huangxulin/spring/_02_spring_test/springTest.xml")

// ContextConfiguration 注解后的参数可以省略
//      1) 此时配置文件应和测试类应放在同一目录
//      2) 配置文件名应为 配置类名-context.xml
// SpringTestTest-context.xml
@ContextConfiguration
public class SpringTestTest {

    // 按照类型自动从Spring容器中寻找对象，并设置给该字段
    @Autowired
    private SomeBean bean;

    @Test
    public void testIoC() {
        bean.doWork();
    }

}
