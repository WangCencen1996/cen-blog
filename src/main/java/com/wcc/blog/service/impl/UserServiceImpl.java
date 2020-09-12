package com.wcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcc.blog.mapper.UserMapper;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.pojo.User;
import com.wcc.blog.service.UserService;
import com.wcc.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String phone, String password) {
        User temp = userMapper.getUserByPhone(phone);
        User user = null;
        if (temp != null){
            if (temp.getPassword().equals(MD5Utils.code(password))){
                user = temp;
            }
        }
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    @Override
    public PageInfo<User> listUser(int page) {
        PageHelper.startPage(page,6);
        List<User> users = userMapper.listUser();
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public boolean saveUser(User user) {
        try {
            user.setPassword(MD5Utils.code(user.getPassword()));
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setCode("111");
            user.setStart(1);
            user.setAdmin(0);
            Random random = new Random();
            user.setAvatar("/images/tx/tx"+(random.nextInt(15)+1)+".jpg");
            userMapper.saveUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            user.setPassword(MD5Utils.code(user.getPassword()));
            user.setUpdateTime(new Date());
            userMapper.updateUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userMapper.deleteUser(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
