package com.wcc.blog.mapper;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    Blog getBlog(Long id);
    List<Blog> listBlog(Blog blog);
    List<Blog> listBlogByQuery(String query);
    void saveBlog(Blog blog);
    void saveBlogToTag(Long blogId,Long tagId);
    void updateBlog(Blog blog);
    void deleteBlog(Long id);
    void deleteBlogToTag(Long id);
    List<Blog> listRecommendBlogTop(int size);

    List<Blog> getBlogByTypeId(Long typeId);

    List<Blog> getBlogByTagId(Long tagId);

    void addViews(Long id);

    List<Blog> listBlogByTagId(Long tagId);

    List<String> listGroupByYear();

    List<Blog> listBlogByYear(String year);

    Long countBlog();
}
