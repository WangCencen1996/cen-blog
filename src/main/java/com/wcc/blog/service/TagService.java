package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Tag;
import com.wcc.blog.pojo.Type;

import java.util.List;


public interface TagService {
    Tag getTag(Long id);
    Tag getTagByName(String name);
    PageInfo<Tag> listTag(int page);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    boolean removeTag(Long id);
    boolean updateTag(Tag tag);
    boolean saveTag(Tag tag);
    List<Tag> listTagTop(int size);
}
