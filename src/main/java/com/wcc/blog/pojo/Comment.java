package com.wcc.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;  //主键
    private String nickname;  //昵称
    private String email;  //邮箱
    private String content;  //评论内容
    private String avatar;  //头像地址
    private Date createTime;  //创建时间
    private Boolean isDelete;
    private Long parent;  //回复哪条评论的id
    private Comment parentComment; //
    private Long blogId;  //回复评论的id
    private Blog blog;  //回复的博客
    private List<Comment> childComments; //该评论的子评论集合
    private Boolean addminComment; //是否是管理员评论

}
