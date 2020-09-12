package com.wcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcc.blog.mapper.BlogMapper;
import com.wcc.blog.mapper.TypeMapper;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public Type getType(Long id) {
        Type type=typeMapper.getType(id);
        return type;
    }

    @Override
    public Type getTypeByName(String name) {
        Type type = typeMapper.getTypeByName(name);
        return type;
    }

    @Override
    public PageInfo<Type> listType(int page) {
        PageHelper.startPage(page,6);
        List<Type> types = typeMapper.listType();
        PageInfo<Type> pageInfo=new PageInfo<>(types);
        return pageInfo;
    }

    @Override
    public List<Type> listType() {
        return typeMapper.listType();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        List<Type> types = typeMapper.listTypeTop(size);
        for (Type type : types) {
            List<Blog> blogs = blogMapper.getBlogByTypeId(type.getId());
            type.setBlogs(blogs);
        }
        return types;
    }

    @Override
    public boolean removeType(Long id) {
        try {
            typeMapper.removeType(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateType(Type type) {
        try {
            typeMapper.updateType(type);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveType(Type type) {
        try {
            typeMapper.saveType(type);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
