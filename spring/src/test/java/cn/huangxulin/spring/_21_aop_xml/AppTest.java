package cn.huangxulin.spring._21_aop_xml;


import cn.huangxulin.spring._21_aop_xml.domain.Employee;
import cn.huangxulin.spring._21_aop_xml.service.IEmployeeService;
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
