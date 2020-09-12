package com.wcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcc.blog.handler.NotFoundException;
import com.wcc.blog.mapper.BlogMapper;
import com.wcc.blog.mapper.TagMapper;
import com.wcc.blog.mapper.TypeMapper;
import com.wcc.blog.mapper.UserMapper;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Tag;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.pojo.User;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.TagService;
import com.wcc.blog.util.MarkdowmUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Blog getBlog(Long id) {
        Blog blog = blogMapper.getBlog(id);
        /*if (blog.getTypeId()!=null){
            Type type = typeMapper.getType(blog.getTypeId());
            blog.setType(type);
        }
        if (blog.getUserId()!=null) {
            User user = userMapper.getUserById(blog.getUserId());
            blog.setUser(user);
        }
        List<Tag> tags = tagMapper.listTagByBlogId(blog.getId());
        blog.setTags(tags);*/
        return blog;
    }
    @Override
    public Blog getConvertBlog(Long id) {
        Blog blog = blogMapper.getBlog(id);
        if (blog == null){
            throw new NotFoundException("该博客不存在");
        }
        blogMapper.addViews(id);
        if (blog.getTypeId()!=null){
            Type type = typeMapper.getType(blog.getTypeId());
            blog.setType(type);
        }
        if (blog.getUserId()!=null) {
            User user = userMapper.getUserById(blog.getUserId());
            blog.setUser(user);
        }
        List<Tag> tags = tagMapper.listTagByBlogId(blog.getId());
        blog.setTags(tags);
        Blog b= new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        //用Markdowm工具类处理博客内容，再保存到博客里
        b.setContent(MarkdowmUtils.markdownToHtmlExtensions(content));
        return b;
    }

    @Override
    public PageInfo<Blog> listBlog(int page, Blog blog) {
        PageHelper.startPage(page,6);
        List<Blog> blogs = blogMapper.listBlog(blog);
        for (Blog blog1 : blogs) {
            if (blog1.getTypeId()!=null) {
                blog1.setType(typeMapper.getType(blog1.getTypeId()));
            }
            blog1.setUser(userMapper.getUserById(blog1.getUserId()));
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> listBlog(int page, String query) {
        PageHelper.startPage(page,6);
        List<Blog> blogs = blogMapper.listBlogByQuery(query);
        for (Blog blog : blogs) {
            User user=userMapper.getUserById(blog.getUserId());
            blog.setUser(user);
            Type type = typeMapper.getType(blog.getTypeId());
            blog.setType(type);
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> listBlog(int page, Long tagId) {
        PageHelper.startPage(page,6);
        List<Blog> blogs = blogMapper.getBlogByTagId(tagId);
        for (Blog blog : blogs) {
            User user=userMapper.getUserById(blog.getUserId());
            blog.setUser(user);
            Type type = typeMapper.getType(blog.getTypeId());
            blog.setType(type);
            List<Tag> tags = tagMapper.listTagByBlogId(blog.getId());
            blog.setTags(tags);
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> listBlog(int page) {
        PageHelper.startPage(page,6);
        List<Blog> blogs = blogMapper.listBlog(new Blog());
        for (Blog blog : blogs) {
            User user=userMapper.getUserById(blog.getUserId());
            blog.setUser(user);
            Type type = typeMapper.getType(blog.getTypeId());
            blog.setType(type);
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        return pageInfo;
    }

    @Override
    public List<Blog> listRecommendBlogTop(int size) {
        return blogMapper.listRecommendBlogTop(size);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        if (blog.getApperciation()==null){
            blog.setApperciation(false);
        }
        if (blog.getShareStatement()==null){
            blog.setShareStatement(false);
        }
        if (blog.getCommentabled()==null){
            blog.setCommentabled(false);
        }
        if (blog.getRecommened()==null){
            blog.setRecommened(false);
        }
        try {
            if (blog.getId() == null){
                blog.setCreateTime(new Date());
                blog.setUpdateTime(new Date());
                blog.setViews(0);
                blog.setUserId(blog.getUser().getId());
                blogMapper.saveBlog(blog);
                for (Tag tag : blog.getTags()) {
                    blogMapper.saveBlogToTag(blog.getId(),tag.getId());
                }
            }else {
                blog.setUpdateTime(new Date());
                blogMapper.updateBlog(blog);
                blogMapper.deleteBlogToTag(blog.getId());
                for (Tag tag : blog.getTags()) {
                    blogMapper.saveBlogToTag(blog.getId(),tag.getId());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBlog(Blog blog) {
        try {
            if (blog.getApperciation()==null){
                blog.setApperciation(false);
            }
            if (blog.getShareStatement()==null){
                blog.setShareStatement(false);
            }
            if (blog.getCommentabled()==null){
                blog.setCommentabled(false);
            }
            if (blog.getRecommened()==null){
                blog.setRecommened(false);
            }
            blogMapper.updateBlog(blog);
            blogMapper.deleteBlogToTag(blog.getId());
            for (Tag tag : blog.getTags()) {
                blogMapper.saveBlogToTag(blog.getId(),tag.getId());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBlog(Long id) {
        try {
            blogMapper.deleteBlog(id);
            blogMapper.deleteBlogToTag(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogMapper.listGroupByYear();
        Map<String,List<Blog>> blogMap = new LinkedHashMap<>();
        for (String year : years) {
            List<Blog> blogs = blogMapper.listBlogByYear(year);
            for (Blog blog : blogs) {
                User user=userMapper.getUserById(blog.getUserId());
                blog.setUser(user);
                Type type = typeMapper.getType(blog.getTypeId());
                blog.setType(type);
                List<Tag> tags = tagMapper.listTagByBlogId(blog.getId());
                blog.setTags(tags);
            }
            blogMap.put(year,blogs);
        }
        return blogMap;
    }

    @Override
    public Long countBlog() {
        return blogMapper.countBlog();
    }
}
