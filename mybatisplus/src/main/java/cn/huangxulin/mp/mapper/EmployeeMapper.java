package cn.huangxulin.mp.mapper;

import cn.huangxulin.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 功能描述: Mapper接口
 *
 * 基于MyBatis: 在Mapper接口中编写CRUD相关的方法, 提供Mapper接口所对应的SQL映射文件以及方法对应的SQL语句
 *
 * 基于MyBatisPlus: 让XxxMapper接口继承BaseMapper接口即可
 *                  BaseMapper<T>: 泛型指定的是当前Mapper接口所操作的实体类类型
 *
 * @author hxulin
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

}
