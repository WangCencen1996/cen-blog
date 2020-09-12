package com.wcc.blog.web.admin;

import com.wcc.blog.pojo.User;
import com.wcc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    //登录页面
    @GetMapping
    public String login(){
        return "login";
    }
    //登录数据处理
    @PostMapping("/login")
    public String login(@RequestParam String phone, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUser(phone, password);
        if (user != null){
            System.out.println(user);
            //登录成功
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            //登录失败，返回登录页面
            attributes.addFlashAttribute("message","用户名或密码错误！");
            return "redirect:/admin";
        }
    }
    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }
    // 注销用户
    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
