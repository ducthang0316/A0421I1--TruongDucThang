package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.ProductType;
import com.example.demo.repository.ProductTypeRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @ModelAttribute("listProductType")
    public List<ProductType> productTypeList (){
        return productTypeRepository.findAll();
    }


    @GetMapping("/list")
    public String displayPage (Model model,
                               @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("productList", productService.findAll(pageable));
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public  String create(@Validated @ModelAttribute("product") Product product,
                          BindingResult bindingResult,
                          Model model,
                          RedirectAttributes redirectAttributes)
    {
        if (bindingResult.hasErrors()){
            return "/create";
        }

        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Successfully created");
        return "redirect:list";
    }
//
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(name = "product") Product product,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Successfully updated");
        return "redirect:list";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@ModelAttribute("product") Product product,
                                @PathVariable Long id, Model model,
                                @PageableDefault(size = 5) Pageable pageable) {
        productService.delete(id);
        model.addAttribute("productList", productService.findAll(pageable));
        return "/resultTable";
    }

    @PostMapping("/search")
    public String search(
            Optional<String> nameSearch,
            Optional<Integer> priceSearch,
//            @RequestParam(value = "nameSearch", required = false, defaultValue = "") String nameSearch,
//            @RequestParam(value = "priceSearch", required = false, defaultValue = "") int priceSearch,
//            @RequestParam(value = "typeIdSearch", required = false, defaultValue = "") Long typeIdSearch,
            @PageableDefault(size = 5) Pageable pageable,
            Model model){

        if (nameSearch.isPresent() ){
            model.addAttribute("nameSearch", nameSearch.get());
            Page<Product> productList = productService.findByNameContaining(pageable ,nameSearch.get());
            model.addAttribute("productList", productList);
        }

//        if (priceSearch.isPresent() ){
//            model.addAttribute("priceSearch", priceSearch.get());
//            List<Product> productList = productService.findByPrice(priceSearch.get());
//            model.addAttribute("productList", productList);
//        }
//
//        if (typeIdSearch != 0 ){
//            List<Product> productList = productService.findByProductTypeId(typeIdSearch);
//            model.addAttribute("productList", productList);
//        }
//        if (nameSearch != "" && priceSearch != 0 && typeIdSearch != 0){
//            List<Product> productList = productService.findAllByNameContainsAndAndPriceAndAndProductType(nameSearch, priceSearch, typeIdSearch);
//            model.addAttribute("productList", productList);
//        } else {
//            Page<Product> productList = productService.findAll(pageable);
//            model.addAttribute("productList", productList);
//        }
        return "/resultTable";
    }
}
