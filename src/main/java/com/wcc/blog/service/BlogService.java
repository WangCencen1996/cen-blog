package com.wcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog getBlog(Long id);
    Blog getConvertBlog(Long id);
    PageInfo<Blog> listBlog(int page,Blog blog);
    PageInfo<Blog> listBlog(int page,String query);
    PageInfo<Blog> listBlog(int page,Long tagId);
    PageInfo<Blog> listBlog(int page);
    List<Blog> listRecommendBlogTop(int size);
    boolean saveBlog(Blog blog);
    boolean updateBlog(Blog blog);
    boolean deleteBlog(Long id);
    Map<String,List<Blog>> archiveBlog();
    Long countBlog();

}
