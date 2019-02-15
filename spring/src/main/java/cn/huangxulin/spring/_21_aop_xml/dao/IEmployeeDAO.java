package cn.huangxulin.spring._21_aop_xml.dao;

import cn.huangxulin.spring._21_aop_xml.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
