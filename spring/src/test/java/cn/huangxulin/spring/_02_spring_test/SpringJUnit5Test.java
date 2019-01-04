package cn.huangxulin.spring._02_spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述: Spring整合JUnit5测试，测试变得更简单
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class SpringJUnit5Test {

    @Autowired
    private SomeBean bean;

    @Test
    void testIoC() {
        bean.doWork();
    }
}
