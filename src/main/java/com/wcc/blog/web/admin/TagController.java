package com.wcc.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Tag;
import com.wcc.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public String list(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Model model){
        if (page <= 0){
            page = 1;
        }
        PageInfo<Tag> pageInfo = tagService.listTag(page);
        model.addAttribute("page",pageInfo);
        return "admin/taglist";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,RedirectAttributes attributes){
        boolean b = tagService.removeTag(id);
        if (b){
            attributes.addFlashAttribute("message","删除成功");
        }
        else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/tag/list";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id",required = false,defaultValue = "-1") Long id,Model model){
        if (id < 0){
            Tag tag=new Tag();
            tag.setId(-1L);
            tag.setName("");
            model.addAttribute("tag",tag);
            return "admin/tagadd";
        }
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tagadd";
    }
    @PostMapping("/add")
    public String add(@RequestParam(name = "id",required = false,defaultValue = "-1") Long id, @RequestParam String name, RedirectAttributes attributes){
        if (name == null){
            attributes.addFlashAttribute("message","操作失败，名字不能为空");
            return "redirect:/admin/tag/edit?id="+id;
        }
        Tag tagByName = tagService.getTagByName(name);
        if (tagByName != null){
            attributes.addFlashAttribute("message","操作失败，该名字已存在");
            return "redirect:/admin/tag/edit?id="+id;
        }
        Tag tag=new Tag();
        tag.setName(name);
        if (id < 0){
            boolean b = tagService.saveTag(tag);
            if (b){
                attributes.addFlashAttribute("message","添加成功");
            }else {
                attributes.addFlashAttribute("message","添加失败");
            }
        }
        tag.setId(id);
        boolean b = tagService.updateTag(tag);
        if (b){
            attributes.addFlashAttribute("message","更新成功");
        }else {
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/tag/list";
    }
    @PostMapping("/search")
    public String search(@RequestParam String title,Model model){
        Tag tag = tagService.getTagByName(title);
        List<Tag> tags= Arrays.asList(tag);
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        model.addAttribute("page",pageInfo);
        return "admin/taglist";
    }

}
