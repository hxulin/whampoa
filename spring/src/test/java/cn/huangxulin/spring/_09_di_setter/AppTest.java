package cn.huangxulin.spring._09_di_setter;

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
    private Employee1 employee1;

    @Autowired
    private Person1 person1;

    @Autowired
    private CollectionBean1 collectionBean1;

    @Test
    void test() {
        System.out.println(employee1);
        System.out.println(person1);
        System.out.println(collectionBean1);
    }
}
