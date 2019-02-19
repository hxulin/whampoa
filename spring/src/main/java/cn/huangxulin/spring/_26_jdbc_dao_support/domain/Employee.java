package cn.huangxulin.spring._26_jdbc_dao_support.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Data
public class Employee {

    private Long id;

    private String username;

    private String name;

    private int age;

    private BigDecimal balance;

}
