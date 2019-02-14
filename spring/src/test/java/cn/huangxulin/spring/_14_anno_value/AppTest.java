package cn.huangxulin.spring._14_anno_value;

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
    private ValueBean valueBean;


    @Test
    void test() {
        System.out.println(valueBean);
    }
}
