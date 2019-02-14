package cn.huangxulin.spring._17_static_proxy.dao;

import cn.huangxulin.spring._17_static_proxy.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
