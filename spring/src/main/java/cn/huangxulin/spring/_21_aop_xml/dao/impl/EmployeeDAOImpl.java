package cn.huangxulin.spring._21_aop_xml.dao.impl;

import cn.huangxulin.spring._21_aop_xml.dao.IEmployeeDAO;
import cn.huangxulin.spring._21_aop_xml.domain.Employee;

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
