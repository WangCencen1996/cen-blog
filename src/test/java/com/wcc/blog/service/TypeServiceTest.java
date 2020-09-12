package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TypeServiceTest extends BlogApplicationTests {
    @Autowired
    private TypeService typeService;

    @Test
    public void list(){
        PageInfo<Type> pageInfo = typeService.listType(1);
        System.out.println(pageInfo.getList());
    }

}