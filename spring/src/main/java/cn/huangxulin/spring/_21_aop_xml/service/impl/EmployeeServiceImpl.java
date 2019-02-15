package cn.huangxulin.spring._21_aop_xml.service.impl;

import cn.huangxulin.spring._21_aop_xml.domain.Employee ;
import cn.huangxulin.spring._21_aop_xml.dao.IEmployeeDAO;
import cn.huangxulin.spring._21_aop_xml.service.IEmployeeService;

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
