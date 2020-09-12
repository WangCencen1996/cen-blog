package com.wcc.blog.web;

import com.wcc.blog.pojo.Blog;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.TagService;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;


    @GetMapping("/")
    public String index(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Blog blog, Model model){
        model.addAttribute("page",blogService.listBlog(page));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(6));
        return "index";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam Long id,Model model){
        model.addAttribute("blog",blogService.getConvertBlog(id));
        return "blog";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Blog blog, Model model,@RequestParam String query){
        model.addAttribute("page",blogService.listBlog(page,query));
        model.addAttribute("query",query);
        return "search";
    }

}
