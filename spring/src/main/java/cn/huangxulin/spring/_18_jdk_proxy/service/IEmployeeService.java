package cn.huangxulin.spring._18_jdk_proxy.service;

import cn.huangxulin.spring._18_jdk_proxy.domain.Employee;

public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);
}
