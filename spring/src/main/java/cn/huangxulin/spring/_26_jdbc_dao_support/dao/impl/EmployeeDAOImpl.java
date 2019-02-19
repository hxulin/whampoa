package cn.huangxulin.spring._26_jdbc_dao_support.dao.impl;

import cn.huangxulin.spring._26_jdbc_dao_support.dao.IEmployeeDAO;
import cn.huangxulin.spring._26_jdbc_dao_support.domain.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO {

    @Override
    public void save(Employee employee) {
        getJdbcTemplate().update("INSERT INTO employee(`id`, `username`, `name`, `age`, `balance`) VALUES (?, ?, ?, ?, ?)", employee.getId(), employee.getUsername(), employee.getName(), employee.getAge(), employee.getBalance());
    }

    @Override
    public void update(Employee employee) {
        getJdbcTemplate().update("UPDATE employee SET `name` = ?, `balance` = ? WHERE `id` = ?", employee.getName(), employee.getBalance(), employee.getId());
    }

    @Override
    public void delete(Long id) {
        getJdbcTemplate().update("DELETE employee WHERE `id` = ?", id);
    }

    @Override
    public Employee get(Long id) {
        List<Employee> list = getJdbcTemplate().query("SELECT `id`, `username`, `name`, `age`, `balance` FROM employee WHERE id = ?", new Object[]{id}, (rs, i) -> {
            Employee e = new Employee();
            e.setId(rs.getLong("id"));
            e.setUsername(rs.getString("username"));
            e.setName(rs.getString("name"));
            e.setAge(rs.getInt("age"));
            e.setBalance(rs.getBigDecimal("balance"));
            return e;
        });
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Employee> listAll() {
        return getJdbcTemplate().query("SELECT `id`, `username`, `name`, `age`, `balance` FROM employee", new Object[]{}, new RowMapper<Employee>() {
            // 把每一行结果集映射成一个 Employee 对象
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setUsername(rs.getString("username"));
                e.setName(rs.getString("name"));
                e.setAge(rs.getInt("age"));
                e.setBalance(rs.getBigDecimal("balance"));
                return e;
            }
        });
    }
}
