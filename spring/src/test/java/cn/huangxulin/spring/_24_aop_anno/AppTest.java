package cn.huangxulin.spring._24_aop_anno;


import cn.huangxulin.spring._24_aop_anno.domain.Employee;
import cn.huangxulin.spring._24_aop_anno.service.IEmployeeService;
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
    private IEmployeeService service;

    @Test
    void testSave() {
        System.out.println(service.getClass().getName());
        service.save(new Employee());
    }

    @Test
    void testUpdate() {
        service.update(new Employee());
    }
}
