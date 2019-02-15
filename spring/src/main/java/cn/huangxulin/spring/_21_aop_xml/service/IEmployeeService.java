package cn.huangxulin.spring._21_aop_xml.service;

import cn.huangxulin.spring._21_aop_xml.domain.Employee ;

public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);
}
