package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class CondimentController {

    @GetMapping(value = "")
    public String display(){
        return "display";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){

        model.addAttribute("condiment", Arrays.toString(condiment));

        return "show";
    }
}
