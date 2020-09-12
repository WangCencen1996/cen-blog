package com.wcc.blog.mapper;

import com.wcc.blog.pojo.User;

import java.util.List;

public interface UserMapper {

    User getUserByPhone(String phone);

    List<User> listUser();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
