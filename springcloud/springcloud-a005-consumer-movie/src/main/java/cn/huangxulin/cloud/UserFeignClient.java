package cn.huangxulin.cloud;

import cn.huangxulin.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@FeignClient("springcloud-a005-provider-user")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    User save(User user);

}
