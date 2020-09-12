package com.wcc.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long id;  //主键
    private String name;  //名称
    private Boolean isDelete;
    private List<Blog> blogs;  //相关博客
}
