package com.example.demo.controller;


import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/list")
    public String listProduct (Model model){
        model.addAttribute("productList", productRepository.findAll());
        return "/list";
    }

//    @GetMapping("/create")
//    public String showCreateForm (Model model){
//        model.addAttribute("person", new Person());
//        return "/create";
//    }
//
//    @PostMapping("/create")
//    public  String create(@Validated @ModelAttribute("person") Person person,
//                          BindingResult bindingResult,
//                          Model model,
//                          RedirectAttributes redirectAttributes)
//    {
//        if (bindingResult.hasErrors()){
//            return "/create";
//        }
//
//        personService.save(person);
//        redirectAttributes.addFlashAttribute("message", "Successfully created");
//        return "redirect:list";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String showEdit(@PathVariable("id") Long id, Model model){
//        Person person = personService.findById(id);
//        model.addAttribute("person", person);
//        return "/edit";
//    }
//
//    @PostMapping("/edit")
//    public String update(@Validated @ModelAttribute(name = "person") Person person,
//                         BindingResult bindingResult,
//                         Model model,
//                         RedirectAttributes redirectAttributes){
//        if (bindingResult.hasErrors()){
//            return "/edit";
//        }
//        personService.save(person);
//        redirectAttributes.addFlashAttribute("message", "Successfully updated");
//        return "redirect:list";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String showDelete(@PathVariable("id") Long id, Model model){
//        model.addAttribute("person", personService.findById(id));
//        return "/delete";
//    }
//
//    @PostMapping("/{id}/delete")
//    public String deleteProduct(@ModelAttribute("person") Person person, @PathVariable Long id, Model model) {
//        personService.delete(id);
//        model.addAttribute("personList", personService.findAll());
//        return "/resultTable";
//    }
//
//    @PostMapping("/search")
//    public String search(
//            @RequestParam("keySearch") String keySearch
//            ,Model model){
//
//        List<Person> personList = personService.findByNameContaining(keySearch);
//        model.addAttribute("personList", personList);
//        return "/resultTable";
//    }
}
