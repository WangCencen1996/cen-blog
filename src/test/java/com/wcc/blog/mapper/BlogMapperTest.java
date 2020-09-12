package com.wcc.blog.mapper;

import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class BlogMapperTest extends BlogApplicationTests {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void save(){
        List<String> years = blogMapper.listGroupByYear();
        for (String year : years) {
            System.out.println(year);
        }

    }

}