package cn.huangxulin.spring._13_di_anno;

import cn.huangxulin.spring._13_di_anno.di.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @Autowired
    private Person person;


    @Test
    void test() {
        System.out.println(person);
    }
}
