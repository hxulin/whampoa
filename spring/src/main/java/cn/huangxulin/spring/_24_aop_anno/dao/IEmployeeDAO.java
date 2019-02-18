package cn.huangxulin.spring._24_aop_anno.dao;

import cn.huangxulin.spring._24_aop_anno.domain.Employee;

public interface IEmployeeDAO {

    void save(Employee employee);

    void update(Employee employee);
}
