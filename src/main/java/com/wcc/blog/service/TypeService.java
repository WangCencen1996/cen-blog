package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Type;

import java.util.List;


public interface TypeService {
    Type getType(Long id);
    Type getTypeByName(String name);
    PageInfo<Type> listType(int page);
    List<Type> listType();
    List<Type> listTypeTop(Integer size);
    boolean removeType(Long id);
    boolean updateType(Type type);
    boolean saveType(Type type);
}
