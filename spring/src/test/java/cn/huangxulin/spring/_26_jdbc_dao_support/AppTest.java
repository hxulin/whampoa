package cn.huangxulin.spring._26_jdbc_dao_support;

import cn.huangxulin.spring._26_jdbc_dao_support.dao.IEmployeeDAO;
import cn.huangxulin.spring._26_jdbc_dao_support.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Test
    void testSave() {
        Employee employee = new Employee();
        employee.setId(5L);
        employee.setUsername("user5");
        employee.setName("田七");
        employee.setAge(25);
        employee.setBalance(new BigDecimal(200.00));
        employeeDAO.save(employee);
        testListAll();
    }

    @Test
    void testUpdate() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("管理员");
        employee.setBalance(new BigDecimal(500.00));
        employeeDAO.update(employee);
        testListAll();
    }

    @Test
    void testDelete() {
        employeeDAO.delete(3L);
        testListAll();
    }

    @Test
    void testGet() {
        System.out.println(employeeDAO.get(3L));
    }

    @Test
    void testListAll() {
        List<Employee> employees = employeeDAO.listAll();
        System.out.println(employees);
    }

}
