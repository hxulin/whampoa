package cn.huangxulin.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 功能描述: 员工实体类
 *
 * @author hxulin
 *
 * MyBatisPlus 会默认使用实体类的类名到数据库中找对应的表
 *
 */
//@TableName("t_employee")
@Getter
@Setter
@ToString
public class Employee {

    /**
     * TableId: value 指定表中的逐渐列的列名, 如果实体属性与别名一致，可以省略不指定
     *          type  指定主键策略
     */
    //@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("first_name")
    private String firstName;

    private String email;

    private Integer gender;

    private Integer age;

    @TableField(exist = false)
    private Double salary;

}
