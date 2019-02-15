package cn.huangxulin.spring._20_cglib_method_interceptor.service;

import cn.huangxulin.spring._20_cglib_method_interceptor.domain.Employee;

public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);
}
