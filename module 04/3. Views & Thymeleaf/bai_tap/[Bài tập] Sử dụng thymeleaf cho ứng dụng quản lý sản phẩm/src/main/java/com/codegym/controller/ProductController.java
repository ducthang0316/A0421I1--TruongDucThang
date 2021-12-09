package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("list",productList);
        return "/index";
    }

    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId(productService.autoIncrease());
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Create new product successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update product successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("mess", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String productName, Model model){
        List<Product> result = productService.findByName(productName);

        if (productName.equals("")){
            List<Product> productList = productService.findAll();
            model.addAttribute("list", productList);
        }

        if (!result.isEmpty()){
            model.addAttribute("list", result );

        } else {
            model.addAttribute("mess", "No matched result!");
        }
        return "/index";
    }
}
