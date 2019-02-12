package cn.huangxulin.spring._10_di_constructor;

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
    private Employee2 employee2;

    @Autowired
    private Person2 person2;

    @Autowired
    private CollectionBean2 collectionBean2;

    @Test
    void test() {
        System.out.println(employee2);
        System.out.println(person2);
        System.out.println(collectionBean2);
    }


}
