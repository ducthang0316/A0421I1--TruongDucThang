package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

   @GetMapping("")
    public String listBlog (Model model){
       List<Blog> blogList =blogService.findAll();
       model.addAttribute("blog", blogList);
       return "/blog/list";
   }

   @GetMapping("/create")
    public String showCreate (Model model){
       model.addAttribute("blog", new Blog());
       return "/blog/create";
   }

   @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully");
        return "redirect:/blog";
   }

   @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model){
       Blog blog = blogService.findById(id);
       if (blog != null){
           model.addAttribute("blog", blog);
           return "/blog/edit";
       } else {
           return "/eror404";
       }
   }

   @PostMapping("/edit")
    public String update(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes){
       blogService.save(blog);
       redirectAttributes.addFlashAttribute("message", "Update blog successfully");
       return "redirect:/blog";
   }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable Long id, Model model){
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "/blog/delete";
        } else {
            return "/eror404";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Delete blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model){
       Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "/blog/view";
        } else {
            return "/eror404";
        }
    }

}
