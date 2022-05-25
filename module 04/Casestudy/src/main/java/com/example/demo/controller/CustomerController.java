package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.repository.customer.CustomerRepository;
import com.example.demo.repository.customer.CustomerTypeRepository;
import com.example.demo.service.customer.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @ModelAttribute("listCustomerType")
    public List<CustomerType> customerTypeList (){
        return customerTypeRepository.findAll();
    }

    @GetMapping("/list")
    public String listCustomer (Model model){
        model.addAttribute("customerList", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/listPage")
    public String displayPage (Model model, Optional<String> keySearch , Optional<Long> typeId,
                               @PageableDefault(size = 2) Pageable pageable){
        if (!keySearch.isPresent()){
            if (typeId.isPresent()){
                model.addAttribute("typeId", typeId.get());
                model.addAttribute("customerList", customerService.findAllByCustomerTypeId(pageable, typeId.get()));
            } else {
                model.addAttribute("customerList", customerService.findAll(pageable));
            }
        } else {
            model.addAttribute("customerList"
                    , customerRepository.findByNameContains(keySearch.get()));
        }

        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public  String create(@Validated @ModelAttribute("customer") Customer customer,
                          BindingResult bindingResult,
                          Model model,
                          RedirectAttributes redirectAttributes)
    {
        if (bindingResult.hasErrors()){
            return "customer/create";
        }

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully");
        return "redirect:list";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable("id") Long id, Model model){
       Customer customer = customerService.findById(id);
       model.addAttribute("customer", customer);
       return "customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(name = "customer") Customer customer,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer successfully");
        return "redirect:list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable("id") Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@ModelAttribute("customer") Customer customer, @PathVariable Long id, Model model) {
        customerService.delete(id);
        model.addAttribute("customerList", customerService.findAll());
        return "customer/resultTable";
    }

    @PostMapping("/search")
    public String search(
            @RequestParam("keySearch") String keySearch
//            ,Optional<String> keySearch
            ,Model model
            ,@PageableDefault(size = 2) Pageable pageable ){
//        System.out.println(keySearch.get());
        Page<Customer> customerList = customerRepository.findByNameContains(pageable , keySearch);
        model.addAttribute("customerList", customerList);
        return "customer/searchTable";
    }



}
