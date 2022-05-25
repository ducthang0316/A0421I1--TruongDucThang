package com.example.demo.controller;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.customer.CustomerRepository;
import com.example.demo.repository.customer.CustomerTypeRepository;
import com.example.demo.repository.employee.EmployeeRepository;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;


//    @GetMapping("/list")
//    public String listCustomer (Model model){
//        model.addAttribute("customerList", customerService.findAll());
//        return "customer/list";
//    }

    @GetMapping("/listPage")
    public String displayPage (Model model,
                               @PageableDefault(size = 2) Pageable pageable){
//        if (!keySearch.isPresent()){
//            if (typeId.isPresent()){
//                model.addAttribute("typeId", typeId.get());
//                model.addAttribute("customerList", customerService.findAllByCustomerTypeId(pageable, typeId.get()));
//            } else {
        model.addAttribute("employeeList", employeeService.findAll(pageable));
//            }
//        } else {
//            model.addAttribute("customerList"
//                    , customerRepository.findByNameContains(keySearch.get()));
//        }

        return "employee/list";
    }
}
