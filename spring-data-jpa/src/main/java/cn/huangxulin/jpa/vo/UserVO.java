package cn.huangxulin.jpa.vo;

import cn.huangxulin.jpa.utils.vo.Sign;

import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class UserVO {

    private Integer id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

    @Sign
    public UserVO(Integer id, String username, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    @Sign(1)
    public UserVO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    @Sign(2)
    public UserVO(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
