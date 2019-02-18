package cn.huangxulin.spring._24_aop_anno.dao.impl;

import cn.huangxulin.spring._24_aop_anno.dao.IEmployeeDAO;
import cn.huangxulin.spring._24_aop_anno.domain.Employee;
import org.springframework.stereotype.Repository;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public void save(Employee employee) {
        System.out.println("保存员工");
    }

    @Override
    public void update(Employee employee) {
        System.out.println("修改员工");
    }
}
