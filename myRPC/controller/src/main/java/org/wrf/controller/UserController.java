package org.wrf.controller;

import com.momo.annotation.MoConsummer;
import com.momo.support.InvokerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wrf.service.UserService;

/**
 * @program: controller
 * @description: 测试Controller
 * @author: Wang.Rongfu
 * @create: 2019-11-08 21:38
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @MoConsummer
    UserService userService = (UserService) InvokerFactory.cache.get(UserService.class.getName());

    @RequestMapping("/login")
    public String login() {
        userService.login("213", "321");
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
