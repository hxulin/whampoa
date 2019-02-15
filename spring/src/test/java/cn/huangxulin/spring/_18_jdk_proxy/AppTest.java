package cn.huangxulin.spring._18_jdk_proxy;


import cn.huangxulin.spring._18_jdk_proxy.domain.Employee;
import cn.huangxulin.spring._18_jdk_proxy.service.IEmployeeService;
import cn.huangxulin.spring._18_jdk_proxy.tx.TransactionManagerAdvice;
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
        // 获取代理对象
        IEmployeeService proxy = transactionManagerAdvice.getProxyObject();
        // System.out.println(proxy.getClass());  // class com.sun.proxy.$Proxy20
        proxy.save(new Employee());
    }

    @Test
    void testUpdate() {
        IEmployeeService proxy = transactionManagerAdvice.getProxyObject();
        proxy.update(new Employee());
    }
}
