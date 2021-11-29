package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {

    @GetMapping(value = "")
    public String display(){
        return "exchange/index";
    }

    @PostMapping(value = "exchange")
    public String exchange(@RequestParam int usd , Model model){

        model.addAttribute("result", usd*23000 );

        return "exchange/index";
    }
}
