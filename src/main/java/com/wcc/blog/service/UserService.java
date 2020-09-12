package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.User;

import java.util.List;

public interface UserService {
    User checkUser(String phone,String password);
    User getUserByPhone(String phone);
    PageInfo<User> listUser(int page);
    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long id);
}
