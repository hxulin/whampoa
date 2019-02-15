package cn.huangxulin.spring._18_jdk_proxy.dao;

import cn.huangxulin.spring._18_jdk_proxy.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
