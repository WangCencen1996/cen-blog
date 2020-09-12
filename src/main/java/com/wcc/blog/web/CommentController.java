package com.wcc.blog.web;

import com.wcc.blog.pojo.Comment;
import com.wcc.blog.pojo.User;
import com.wcc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public String comments(@RequestParam Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            comment.setAvatar(user.getAvatar());
            comment.setNickname(user.getNickname());
            comment.setEmail(user.getEmail());
            comment.setAddminComment(true);
        }else {
            Random random = new Random();
            comment.setAvatar("/images/tx/tx"+(random.nextInt(15)+1)+".jpg");
            comment.setAddminComment(false);
        }
        commentService.saveComment(comment);
        return "redirect:/comments?blogId="+comment.getBlogId();
    }
}
