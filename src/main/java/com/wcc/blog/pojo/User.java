package com.wcc.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String phone;
    private String password;
    private String email;
    private String avatar;  //头像地址
    private Integer admin;  //是否管理员还是其他用户
    private String code;  //注册发送的验证码
    private Integer start;  //是否激活
    private Date createTime;
    private Date updateTime;
    private Boolean isDelete;
    private List<Blog> blogs;  //一个用户对应多个博客
    private List<Comment> comments;  //一个分类对应多条评论
}
