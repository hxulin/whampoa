package cn.huangxulin.spring._20_cglib_method_interceptor.dao.impl;

import cn.huangxulin.spring._20_cglib_method_interceptor.dao.IEmployeeDAO;
import cn.huangxulin.spring._20_cglib_method_interceptor.domain.Employee;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public void save(Employee employee) {
        System.out.println("保存员工");
    }

    @Override
    public void update(Employee employee) {
        System.out.println("修改员工");
    }
}
