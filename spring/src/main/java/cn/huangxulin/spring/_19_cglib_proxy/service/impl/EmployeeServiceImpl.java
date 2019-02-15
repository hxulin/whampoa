package cn.huangxulin.spring._19_cglib_proxy.service.impl;

import cn.huangxulin.spring._19_cglib_proxy.dao.IEmployeeDAO;
import cn.huangxulin.spring._19_cglib_proxy.domain.Employee;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class EmployeeServiceImpl {

    private IEmployeeDAO dao;

    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }

    public void save(Employee employee) {
        dao.save(employee);
        System.out.println("保存成功");
    }

    public void update(Employee employee) {
        dao.update(employee);
        throw new RuntimeException("故意出错的");
    }
}
