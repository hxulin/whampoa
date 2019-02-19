package cn.huangxulin.spring._26_jdbc_dao_support.dao;

import cn.huangxulin.spring._26_jdbc_dao_support.domain.Employee;

import java.util.List;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();
}
