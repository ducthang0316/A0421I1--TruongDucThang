package com.example.bt_bai_7.controller;

import com.example.bt_bai_7.model.Blog;
import com.example.bt_bai_7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

}
