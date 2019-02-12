package cn.huangxulin.spring._08_xml_autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述: XML 自动装配，不推荐使用
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
