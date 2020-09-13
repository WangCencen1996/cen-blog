package com.wcc.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Comment;
import com.wcc.blog.pojo.User;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.CommentService;
import com.wcc.blog.service.TagService;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {
    private static final String INPUT = "admin/blogs-input";
    private static final String List = "admin/bloglist";
    private static final String REDIRECT_List = "redirect:admin/bloglist";
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String blogs(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Blog blog, Model model){
        model.addAttribute("types",typeService.listType());
        PageInfo<Blog> blogPageInfo = blogService.listBlog(page, blog);
        model.addAttribute("page",blogPageInfo);
        return "admin/bloglist";
    }
    @PostMapping("/list/search")
    public String search(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Blog blog, Model model){
        if (page<=0){
            page=1;
        }
        model.addAttribute("page",blogService.listBlog(page,blog));
        return "admin/bloglist :: blogList";
    }
    @GetMapping("/add")
    public String edit(Model model){
        setTypeAndTag(model);
        model.addAttribute("blog",new Blog());
        return "admin/blogs-add";
    }

    private void setTypeAndTag(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
    }

    @GetMapping("/edit")
    public String edit(Model model,@RequestParam Long id){
        setTypeAndTag(model);
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog",blog);
        model.addAttribute("comments",commentService.listCommentByBlogId(id));
        return "admin/blogs-input";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes attributes){
        System.out.println("delete id= "+id);
        boolean b = blogService.deleteBlog(id);
        if (b){
            commentService.deleteCommentByBlogId(id);
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog/list";
    }
    @PostMapping("/add")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes){
        System.out.println(blog);
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        boolean b = blogService.saveBlog(blog);
        if (b){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog/list";
    }
    //显示评论
    /*@GetMapping("/comments")
    public String comments(@RequestParam Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blogs-input :: commentlist";
    }*/
    //删除评论
    @GetMapping("/commentDelete")
    public String delete(@RequestParam Long id,@RequestParam Long commentId, RedirectAttributes attributes, Model model){
        commentService.deleteComment(commentId);
        return "redirect:/admin/blog/edit?id="+id;
    }


}
