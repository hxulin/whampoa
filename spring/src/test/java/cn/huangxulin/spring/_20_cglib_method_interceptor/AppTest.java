package cn.huangxulin.spring._20_cglib_method_interceptor;



import cn.huangxulin.spring._20_cglib_method_interceptor.domain.Employee;
import cn.huangxulin.spring._20_cglib_method_interceptor.log.LogAdvice;
import cn.huangxulin.spring._20_cglib_method_interceptor.service.impl.EmployeeServiceImpl;
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
    private LogAdvice advice;

    @Test
    void testSave() {
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.save(new Employee());
    }

    @Test
    void testUpdate() {
        EmployeeServiceImpl proxy = advice.getProxyObject();
        proxy.update(new Employee());
    }
}
