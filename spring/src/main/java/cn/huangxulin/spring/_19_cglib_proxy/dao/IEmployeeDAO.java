package cn.huangxulin.spring._19_cglib_proxy.dao;

import cn.huangxulin.spring._19_cglib_proxy.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
