package cn.huangxulin.spring._24_aop_anno.service.impl;

import cn.huangxulin.spring._24_aop_anno.dao.IEmployeeDAO;
import cn.huangxulin.spring._24_aop_anno.domain.Employee;
import cn.huangxulin.spring._24_aop_anno.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDAO dao;

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
