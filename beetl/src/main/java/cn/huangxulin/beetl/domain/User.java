package cn.huangxulin.beetl.domain;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Data
public class User {

    private String name;

    private Wife wife;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

}
