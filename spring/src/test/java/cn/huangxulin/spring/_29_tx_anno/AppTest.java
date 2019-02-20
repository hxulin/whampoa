package cn.huangxulin.spring._29_tx_anno;

import cn.huangxulin.spring._29_tx_anno.service.IAccountService;
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
    private IAccountService service;

    @Test
    void testTrans() {
        service.trans(10086L, 10010L, 1000);
    }

    @Test
    void testListAll() {
        System.out.println(service.listAll());
    }

}
