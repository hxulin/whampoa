package cn.huangxulin.jpa.service;

import cn.huangxulin.jpa.repository.UserRepository;
import cn.huangxulin.jpa.utils.vo.ModelMap;
import cn.huangxulin.jpa.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserVO> query() {
        List<Object[]> list = userRepository.query();
        return ModelMap.mapping(list, UserVO.class);
    }

    public List<UserVO> query1() {
        List<Object[]> list = userRepository.query1();
        return ModelMap.mapping(list, UserVO.class, 1);
    }

    public List<UserVO> query2() {
        List<Object[]> list = userRepository.query2();
        return ModelMap.mapping(list, UserVO.class, 2);
    }
}
