package com.wcc.blog.mapper;

import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest extends BlogApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void checkUser(){
        User user = userMapper.getUserByPhone("123");
        System.out.println(user);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setNickname("杰克");
        user.setPhone("222");
        user.setPassword("222");
        user.setEmail("333");
        userMapper.updateUser(user);
    }
}