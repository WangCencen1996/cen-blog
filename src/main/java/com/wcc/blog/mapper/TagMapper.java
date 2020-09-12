package com.wcc.blog.mapper;

import com.wcc.blog.pojo.Tag;

import java.util.List;

public interface TagMapper {
    Tag getTag(Long id);
    Tag getTagByName(String name);

    List<Tag> listTag();

    void removeTag(Long id);

    void updateTag(Tag tag);

    void saveTag(Tag tag);

    List<Tag> listTagTop(int size);

    List<Tag> listTagByBlogId(Long blogId);
}
