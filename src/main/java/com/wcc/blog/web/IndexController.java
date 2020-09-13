package com.wcc.blog.web;

import com.wcc.blog.pojo.Blog;
import com.wcc.blog.service.BlogService;
import com.wcc.blog.service.TagService;
import com.wcc.blog.service.TypeService;
import com.wcc.blog.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private VisitService visitService;

    @GetMapping("/")
    public String index(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Blog blog, Model model, HttpServletRequest request){
        // 获取请求的ip地址
        /*String ip = getIpAddress(request);
        System.out.println(ip);
        visitService.saveIP(ip);*/
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

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: newBlogList";
    }

    //获取客户端IP地址
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

}
