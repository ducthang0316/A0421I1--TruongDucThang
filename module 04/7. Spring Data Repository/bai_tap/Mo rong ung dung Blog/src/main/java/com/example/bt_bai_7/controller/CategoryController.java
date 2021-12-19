package com.example.bt_bai_7.controller;

import com.example.bt_bai_7.model.Blog;
import com.example.bt_bai_7.model.Category;
import com.example.bt_bai_7.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("categories", categoryService.findAll() );
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreate (Model model ){
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public  String create(@ModelAttribute("category") Category category , RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create new category successfully");
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String showEdit (@PathVariable("id") Long id, Model model){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            model.addAttribute("category", category);
            return "/category/edit";
        } else {
            return "/error404";
        }
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute(name = "category") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update category successfully");
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable Long id, Model model){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            model.addAttribute("category", category);
            return "/category/delete";
        } else {
            return "/error404";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(name = "category") Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("message", "Delete category successfully");
        return "redirect:/category";
    }
}
