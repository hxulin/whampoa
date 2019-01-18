package cn.huangxulin.mp.test;

import cn.huangxulin.mp.beans.Employee;
import cn.huangxulin.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 通用的插入操作
     */
    @Test
    public void testCommonInsert() {
        // 初始化Employee对象
        Employee employee = new Employee();
        employee.setFirstName("Castle");
        employee.setEmail("castle@huangxulin.cn");
//        employee.setGender(1);
//        employee.setAge(18);
        employee.setSalary(20000.0);
        // 插入到数据库中
        // insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
//        Integer result = employeeMapper.insert(employee);

        // insertAllColumn方法在插入时, 不管属性是否为空, 属性所对应的字段都会出现到SQL语句中　
        Integer result = employeeMapper.insertAllColumn(employee);

        System.out.println("result: " + result);

        // 获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key: " + key);
    }

    /**
     * 通用的更新操作
     */
    @Test
    public void testCommonUpdate() {
        // 初始化修改对象
        Employee employee = new Employee();
        employee.setId(10);
        employee.setFirstName("XXX");
        employee.setEmail("xxx@huangxulin.cn");
        employee.setGender(0);
//        employee.setAge(17);

//        Integer result = employeeMapper.updateById(employee);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println("result: " + result);
    }

    /**
     * 通用的查询操作
     */
    @Test
    public void testCommonSelect() {
        // 1、通过id查询
//        Employee employee = employeeMapper.selectById(8);
//        System.out.println(employee);

        // 2、通过多个列进行查询 id + firstName
//        Employee employee = new Employee();
//        employee.setId(8);
//        employee.setFirstName("MyBatisPlus");
//        employee.setGender(0);
//        Employee result = employeeMapper.selectOne(employee);
//        System.out.println(result);

        // 3、通过多个id进行查询, MyBatis中需要使用<foreach>实现
//        List<Integer> idList = Arrays.asList(4, 5, 6, 7);
//        List<Employee> employees = employeeMapper.selectBatchIds(idList);
//        System.out.println(employees);

        // 4、通过Map封装条件查询
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("first_name", "Tom");
//        columnMap.put("gender", 1);
//        List<Employee> employees = employeeMapper.selectByMap(columnMap);
//        System.out.println(employees);

        // 5、分页查询
        int current = 3;
        int page = 2;
        // 这种方式是内存分页
        List<Employee> employees = employeeMapper.selectPage(new Page<>(current, page), null);
        System.out.println(employees);
    }

    /**
     * 通用的删除操作
     */
    @Test
    public void testCommonDelete() {
        // 1、根据id进行删除
//        Integer result = employeeMapper.deleteById(13);
//        System.out.println(result);

        // 2、根据条件进行删除
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("first_name", "castle");
//        columnMap.put("email", "castle@huangxulin.cn");
//        Integer result = employeeMapper.deleteByMap(columnMap);
//        System.out.println(result);

        // 3、批量删除
        List<Integer> idList = Arrays.asList(8, 9, 10);
        Integer result = employeeMapper.deleteBatchIds(idList);
        System.out.println(result);
    }

}
