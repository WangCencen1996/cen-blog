package com.wcc.blog.service;

import com.wcc.blog.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    boolean saveComment(Comment comment);

    boolean deleteComment(Long commentId);

    boolean deleteCommentByBlogId(Long blogId);
}
