package com.wcc.blog.mapper;

import com.wcc.blog.pojo.Type;

import java.util.List;

public interface TypeMapper {
    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    void removeType(Long id);

    void updateType(Type type);

    void saveType(Type type);

    List<Type> listTypeTop(Integer size);
}
