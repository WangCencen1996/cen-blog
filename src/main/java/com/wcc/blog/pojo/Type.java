package com.wcc.blog.pojo;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Long id;  // 主键
    private String name;  // 分类名字
    private Boolean isDelete;
    private List<Blog> blogs;  //一个分类对应多个博客

}
