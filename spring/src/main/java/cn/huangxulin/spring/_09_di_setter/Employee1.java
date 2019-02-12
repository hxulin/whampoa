package cn.huangxulin.spring._09_di_setter;

import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class Employee1 {

    private String name;

    private Integer age;

    private BigDecimal salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
