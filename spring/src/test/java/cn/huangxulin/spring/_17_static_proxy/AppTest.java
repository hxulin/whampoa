package cn.huangxulin.spring._17_static_proxy;

import cn.huangxulin.spring._17_static_proxy.domain.Employee;
import cn.huangxulin.spring._17_static_proxy.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Qualifier("employeeServiceProxy")
    private IEmployeeService service;

    @Test
    void testSave() {
        service.save(new Employee());

    }

    @Test
    void testUpdate() {
        service.update(new Employee());
    }
}
