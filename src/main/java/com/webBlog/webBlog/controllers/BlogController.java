package com.webBlog.webBlog.controllers;

import com.webBlog.webBlog.userManager.model.UserBlog;
import com.webBlog.webBlog.userManager.services.UserBlogService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    private UserBlogService userBlogService;

    @Autowired
    public BlogController(UserBlogService userBlogService) {
        this.userBlogService = userBlogService;
    }

    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("blog", userBlogService.getAll());
        return "blog";
    }

    @GetMapping("/blog/delete")
    public String blog(@RequestParam int id, Model model){
        userBlogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/blog/updateBlog")
    public String updateBlog(@RequestParam int id, Model model){
        model.addAttribute("element", userBlogService.getById(id));
        return "updateBlog";
    }

    @PostMapping("/blog/updateBlog")
    public String updateBlogs(@RequestParam int id,@RequestParam String title, @RequestParam String description, Model model){
        model.addAttribute("blog", userBlogService.updateBlog(id, title, description));
        return "redirect:/blog";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model){
        return "addBlog";
    }

    @PostMapping("/addBlog")
    public String addBlogs(@RequestParam String title, @RequestParam String description, Model model){
        if (title != null && title != "") {
            userBlogService.createBlog(title, description);
        }
        return "redirect:/blog";
    }

    @GetMapping("/blog/searchBlog")
    public String searchBlog(){
        return "searchBlog";
    }

    @PostMapping("/blog/searchBlog")
    public String searchingBlog(@RequestParam String title, @RequestParam String description, Model model){
        model.addAttribute("search", userBlogService.searchBlog(title, description));
        return "searchBlog";
    }
}
