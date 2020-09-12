package com.wcc.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.wcc.blog.pojo.Type;
import com.wcc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    public String list(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Model model){
        if (page <= 0){
            page = 1;
        }
        PageInfo<Type> pageInfo = typeService.listType(page);
        model.addAttribute("page",pageInfo);
        return "admin/typelist";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,RedirectAttributes attributes){
        boolean b = typeService.removeType(id);
        if (b){
            attributes.addFlashAttribute("message","删除成功");
        }
        else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/type/list";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id",required = false,defaultValue = "-1") Long id,Model model){
        if (id < 0){
            Type type=new Type();
            type.setId(-1L);
            type.setName("");
            model.addAttribute("type",type);
            return "admin/typeadd";
        }
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/typeadd";
    }
    @PostMapping("/add")
    public String add(@RequestParam(name = "id",required = false,defaultValue = "-1") Long id, @RequestParam String name, RedirectAttributes attributes){
        if (name == null){
            attributes.addFlashAttribute("message","操作失败，名字不能为空");
            return "redirect:/admin/type/edit?id="+id;
        }
        Type typeByName = typeService.getTypeByName(name);
        if (typeByName != null){
            attributes.addFlashAttribute("message","操作失败，该名字已存在");
            return "redirect:/admin/type/edit?id="+id;
        }
        Type type=new Type();
        type.setName(name);
        if (id < 0){
            boolean b = typeService.saveType(type);
            if (b){
                attributes.addFlashAttribute("message","添加成功");
            }else {
                attributes.addFlashAttribute("message","添加失败");
            }
        }
        type.setId(id);
        boolean b = typeService.updateType(type);
        if (b){
            attributes.addFlashAttribute("message","更新成功");
        }else {
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/type/list";
    }
    @PostMapping("/search")
    public String search(@RequestParam String title,Model model){
        Type type = typeService.getTypeByName(title);
        List<Type> types= Arrays.asList(type);
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("page",pageInfo);
        return "admin/typelist";
    }

}
