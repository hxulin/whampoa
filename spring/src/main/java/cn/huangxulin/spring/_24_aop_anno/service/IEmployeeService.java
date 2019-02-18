package cn.huangxulin.spring._24_aop_anno.service;

import cn.huangxulin.spring._24_aop_anno.domain.Employee;

public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);
}
