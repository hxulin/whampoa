package cn.huangxulin.spring._25_spring_jdbc.dao;

import cn.huangxulin.spring._25_spring_jdbc.domain.Employee;

import java.util.List;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();
}
