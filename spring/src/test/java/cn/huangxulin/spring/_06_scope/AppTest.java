package cn.huangxulin.spring._06_scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述: Bean 的四种实例化方式
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @Autowired
    private Dog dog1;

    @Autowired
    private Dog dog2;

    @Autowired
    private Dog dog3;

    @Test
    void test() {
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);
    }

}
