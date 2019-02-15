package cn.huangxulin.spring._18_jdk_proxy.dao.impl;

import cn.huangxulin.spring._18_jdk_proxy.dao.IEmployeeDAO;
import cn.huangxulin.spring._18_jdk_proxy.domain.Employee;

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
