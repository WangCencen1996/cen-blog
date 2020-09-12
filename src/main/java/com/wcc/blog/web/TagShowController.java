package com.wcc.blog.web;

import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Tag;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tags")
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/list/{id}")
    public String tags(@RequestParam(name = "page",required = false,defaultValue = "1") int page, @PathVariable Long id, Model model){
        List<Tag> tags = tagService.listTagTop(1000);
        if (id == -1){
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("activeTagId",id);
        model.addAttribute("page",blogService.listBlog(page,id));
        return "tags";
    }
}
