package cn.huangxulin.spring._20_cglib_method_interceptor.dao;

import cn.huangxulin.spring._20_cglib_method_interceptor.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
