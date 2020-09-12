package com.wcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcc.blog.mapper.BlogMapper;
import com.wcc.blog.mapper.TagMapper;
import com.wcc.blog.mapper.TypeMapper;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Tag;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.service.TagService;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Tag getTag(Long id) {
        Tag tag=tagMapper.getTag(id);
        return tag;
    }

    @Override
    public Tag getTagByName(String name) {
        Tag tag=tagMapper.getTagByName(name);
        return tag;
    }

    @Override
    public PageInfo<Tag> listTag(int page) {
        PageHelper.startPage(page,6);
        List<Tag> tags = tagMapper.listTag();
        PageInfo<Tag> pageInfo=new PageInfo<>(tags);
        return pageInfo;
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    // 字符串转换成数组
    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public List<Tag> listTag(String ids) {
        List<Tag> tags =new ArrayList<>();
        List<Long> ids1 = convertToList(ids);
        for (Long aLong : ids1) {
            Tag tag = tagMapper.getTag(aLong);
            tags.add(tag);
        }
        return tags;
    }


    @Override
    public boolean removeTag(Long id) {
        try {
            tagMapper.removeTag(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTag(Tag tag) {
        try {
            tagMapper.updateTag(tag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveTag(Tag tag) {
        try {
            tagMapper.saveTag(tag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tag> listTagTop(int size) {
        List<Tag> tags = tagMapper.listTagTop(size);
        for (Tag tag : tags) {
            List<Blog> blogs = blogMapper.getBlogByTagId(tag.getId());
            tag.setBlogs(blogs);
        }
        return tags;
    }
}
