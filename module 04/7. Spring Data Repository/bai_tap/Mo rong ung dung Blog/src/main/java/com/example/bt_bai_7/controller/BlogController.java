package com.example.bt_bai_7.controller;

import com.example.bt_bai_7.model.Blog;
import com.example.bt_bai_7.model.Category;
import com.example.bt_bai_7.repository.CategoryRepository;
import com.example.bt_bai_7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("listCategory")
    public List<Category> categoryList (Model model){
        return categoryRepository.findAll();
    }
    @GetMapping("")
    public String list(Model model, Optional<String> title_search, Optional<Long> categoryId, @PageableDefault (size = 2) Pageable pageable){
        if (!title_search.isPresent()){
            if (categoryId.isPresent()){
                model.addAttribute("categoryId", categoryId.get());
                model.addAttribute("blogs", blogService.findAllByCategoryId(pageable, categoryId.get()));
            } else {
                model.addAttribute("blogs", blogService.findAll(pageable));
            }
        } else {
            model.addAttribute("blogs", blogService.findAllBlogByTitle(pageable, title_search.get()));
        }
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog);
            return "/blog/edit";
        } else {
            return "/error404";
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
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog);
            return "/blog/delete";
        } else {
            return "/error404";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("message", "Delete blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog);
            return "/blog/view";
        } else {
            return "/error404";
        }
    }
}
