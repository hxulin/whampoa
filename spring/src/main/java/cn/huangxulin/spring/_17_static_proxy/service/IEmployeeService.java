package cn.huangxulin.spring._17_static_proxy.service;

import cn.huangxulin.spring._17_static_proxy.domain.Employee;

public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);
}
