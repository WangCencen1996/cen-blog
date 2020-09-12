package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

class BlogServiceTest extends BlogApplicationTests {
    @Autowired
    private BlogService blogService;

    @Test
    public void list(){
        Blog blog = new Blog();
        PageInfo<Blog> pageInfo = blogService.listBlog(1);
        for (Blog blog1 : pageInfo.getList()) {
            System.out.println(blog1.getUser().getNickname());
        }
    }
    @Test
    public void get(){
        Map<String, List<Blog>> stringListMap = blogService.archiveBlog();
        for (String s : stringListMap.keySet()) {
            System.out.println(s);
        }

    }

}