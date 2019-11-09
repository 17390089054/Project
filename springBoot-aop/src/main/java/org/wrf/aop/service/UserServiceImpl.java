package org.wrf.aop.service;

import org.springframework.stereotype.Component;

/**
 * @program: springBoot-aop
 * @description: 实现类
 * @author: Wang.Rongfu
 * @create: 2019-11-09 19:46
 **/
@Component
public class UserServiceImpl implements UserService {
    public String login() {
        return "UserLogin";
    }
}
