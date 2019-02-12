package cn.huangxulin.spring._05_create_bean;

import cn.huangxulin.spring._05_create_bean._01_constructor.Cat1;
import cn.huangxulin.spring._05_create_bean._02_static_factory.Cat2;
import cn.huangxulin.spring._05_create_bean._02_static_factory.Cat2Factory;
import cn.huangxulin.spring._05_create_bean._03_instance_factory.Cat3;
import cn.huangxulin.spring._05_create_bean._03_instance_factory.Cat3Factory;
import cn.huangxulin.spring._05_create_bean._04_factory_bean.Cat4;
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
    private Cat1 c1;

    @Autowired
    private Cat2 c2;

    @Autowired
    private Cat3 c3;

    @Autowired
    private Cat4 c4;

    @Test
    void testOld() {
        // 方式1：构造器
        Cat1 c1 = new Cat1();
        // 方式2：静态工厂方法
        Cat2 c2 = Cat2Factory.createInstance();
        // 方式3：实例工厂方法
        Cat3 cat3 = new Cat3Factory().createInstance();
    }

    @Test
    void test() {
        System.out.println(c1);
    }

    @Test
    void test2() {
        System.out.println(c2);
    }

    @Test
    void test3() {
        System.out.println(c3);
    }

    @Test
    void test4() {
        System.out.println(c4);
    }

}
