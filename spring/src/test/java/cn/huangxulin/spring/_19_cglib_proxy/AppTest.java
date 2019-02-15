package cn.huangxulin.spring._19_cglib_proxy;


import cn.huangxulin.spring._19_cglib_proxy.domain.Employee;
import cn.huangxulin.spring._19_cglib_proxy.service.impl.EmployeeServiceImpl;
import cn.huangxulin.spring._19_cglib_proxy.tx.TransactionManagerAdvice;
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
    private TransactionManagerAdvice transactionManagerAdvice;

    @Test
    void testSave() {
        EmployeeServiceImpl proxy = transactionManagerAdvice.getProxyObject();
        //System.out.println(proxy.getClass());  // class cn.huangxulin...service.impl.EmployeeServiceImpl$$EnhancerByCGLIB$$12d7430a
        proxy.save(new Employee());
    }

    @Test
    void testUpdate() {
        EmployeeServiceImpl proxy = transactionManagerAdvice.getProxyObject();
        proxy.update(new Employee());
    }
}
