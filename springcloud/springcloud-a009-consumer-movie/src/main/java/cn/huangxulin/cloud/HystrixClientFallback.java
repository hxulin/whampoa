package cn.huangxulin.cloud;

import cn.huangxulin.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Component
public class HystrixClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
