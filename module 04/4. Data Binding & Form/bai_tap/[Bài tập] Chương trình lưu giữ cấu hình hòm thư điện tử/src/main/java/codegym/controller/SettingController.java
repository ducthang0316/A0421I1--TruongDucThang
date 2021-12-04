package codegym.controller;


import codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;



@Controller

public class SettingController {
    private List<Setting> settingList = new ArrayList<>();
    @GetMapping("/set")
    public String showSetting(Model model){
        model.addAttribute("setting", new Setting());
        return "setting";
    }

    @PostMapping("/set")
    public String set(@ModelAttribute ("setting") Setting setting){
        settingList.add(setting);
        return "redirect:/result";
    }

    @GetMapping ("/result")
    public String result(Model model){
        model.addAttribute("result", settingList);
        return "result";
    }
}
