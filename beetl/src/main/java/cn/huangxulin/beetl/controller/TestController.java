package cn.huangxulin.beetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述:
 *
 * @author hxulin
 * 2019-05-20
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("userName", "张三");
        return "index";
    }
}
