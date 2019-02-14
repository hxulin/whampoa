package cn.huangxulin.spring._17_static_proxy.service.impl;

import cn.huangxulin.spring._17_static_proxy.dao.IEmployeeDAO;
import cn.huangxulin.spring._17_static_proxy.domain.Employee;
import cn.huangxulin.spring._17_static_proxy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO dao;

    @Autowired
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
