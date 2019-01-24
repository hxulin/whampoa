package cn.huangxulin.cloud.controller;

import cn.huangxulin.cloud.entity.User;
import cn.huangxulin.cloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userMapper.selectById(id);
    }
}
