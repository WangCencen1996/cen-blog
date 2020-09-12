package com.wcc.blog.service.impl;

import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.User;
import com.wcc.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends BlogApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void checkUser(){
        User user = userService.checkUser("123", "123");
        System.out.println(user);
    }
    @Test
    public void saveUser(){
        User user = new User();
        user.setNickname("马克");
        user.setPhone("222");
        user.setPassword("222");
        user.setEmail("222");
        boolean b = userService.saveUser(user);
        System.out.println(b);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(6L);
        user.setNickname("杰克");
        user.setPhone("222");
        user.setPassword("222");
        user.setEmail("333");
        boolean b = userService.updateUser(user);
        System.out.println(b);
    }
}