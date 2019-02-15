package cn.huangxulin.spring._20_cglib_method_interceptor.service.impl;

import cn.huangxulin.spring._20_cglib_method_interceptor.dao.IEmployeeDAO;
import cn.huangxulin.spring._20_cglib_method_interceptor.domain.Employee;
import cn.huangxulin.spring._20_cglib_method_interceptor.service.IEmployeeService;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO dao;

    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Employee employee) {
        dao.save(employee);
        System.out.println("保存成功");
    }

    @Override
    public void update(Employee employee) {
        dao.update(employee);
        throw new RuntimeException("故意出错的");
    }
}
