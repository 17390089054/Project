package org.wrf.service;

/**
 * @program: service
 * @description: 用户服务实现
 * @author: Wang.Rongfu
 * @create: 2019-11-08 22:17
 **/
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("用户登录");
    }

    @Override
    public void register() {
        System.out.println("用户注册");
    }
}
