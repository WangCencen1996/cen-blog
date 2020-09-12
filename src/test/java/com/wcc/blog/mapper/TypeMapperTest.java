package com.wcc.blog.mapper;

import com.wcc.blog.BlogApplicationTests;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeMapperTest extends BlogApplicationTests {
    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void save(){
        Type type=new Type();
        type.setId(Long.valueOf(8));
        type.setName("日记");
        typeMapper.updateType(type);
    }
    @Test
    public void listTop(){
        List<Type> types = typeMapper.listTypeTop(4);
        for (Type type : types) {
            System.out.println(type);
        }
    }

}