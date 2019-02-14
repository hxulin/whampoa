package cn.huangxulin.spring._17_static_proxy.proxy;

import cn.huangxulin.spring._17_static_proxy.domain.Employee;
import cn.huangxulin.spring._17_static_proxy.service.IEmployeeService;
import cn.huangxulin.spring._17_static_proxy.tx.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述: 静态代理类
 *
 * @author hxulin
 */
@Service
public class EmployeeServiceProxy implements IEmployeeService {


    @Autowired
    private IEmployeeService target;  // 真实对象/委托对象

    @Autowired
    private TransactionManager txManager;

    @Override
    public void save(Employee employee) {
        txManager.begin();
        try {
            target.save(employee);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
    }

    @Override
    public void update(Employee employee) {
        txManager.begin();
        try {
            target.update(employee);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
    }
}
