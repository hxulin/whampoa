package cn.huangxulin.cloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Data
public class User {

    private Long id;

    private String username;

    private String name;

    private Short age;

    private BigDecimal balance;
}
