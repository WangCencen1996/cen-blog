package com.wcc.blog.mapper;

import com.wcc.blog.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> listCommentByBlogId(Long blogId);

    void saveComment(Comment comment);

    Comment getComment(Long id);

    List<Comment> listParentCommentByBlogId(Long blogId);

    List<Comment> listCommentByParent(Long parentId);

    void deleteComment(Long id);

    void deleteCommentByBlogId(Long blogId);
}
