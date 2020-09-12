package com.wcc.blog.web;

import com.wcc.blog.pojo.Blog;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/types")
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/list/{id}")
    public String types(@RequestParam(name = "page",required = false,defaultValue = "1") int page, @PathVariable Long id, Model model){
        List<Type> types = typeService.listTypeTop(1000);
        if (id == -1){
            id = types.get(0).getId();
        }
        model.addAttribute("types",types);
        model.addAttribute("activeTypeId",id);
        Blog blog = new Blog();
        blog.setTypeId(id);
        model.addAttribute("page",blogService.listBlog(page,blog));
        return "types";
    }
}
