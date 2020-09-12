package com.wcc.blog.service.impl;

import com.wcc.blog.mapper.CommentMapper;
import com.wcc.blog.pojo.Comment;
import com.wcc.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        List<Comment> comments=commentMapper.listParentCommentByBlogId(blogId);
        for (Comment comment : comments) {
            comment.setChildComments(commentMapper.listCommentByParent(comment.getId()));
        }
        return comments;
    }

    @Override
    public boolean saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        commentMapper.saveComment(comment);
        return true;
    }

    //循环每个顶级的评论节点
    private List<Comment> eachComment(List<Comment> comments){
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }
    private void combineChildren(List<Comment> comments){
        for (Comment comment : comments) {
            List<Comment> childrens = comment.getChildComments();
            for (Comment comment1 : childrens) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(comment1);
            }
            //修改顶级节点的child集合为迭代处理后的集合
            comment.setChildComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
    }
    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    //递归迭代，剥洋葱
    private void recursively(Comment comment){
        tempReplys.add(comment); //顶级节点添加到临时存放集合
        if (comment.getChildComments().size()>0){
            List<Comment> replys = comment.getChildComments();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getChildComments().size()>0){
                    recursively(reply);
                }
            }
        }
    }
}
