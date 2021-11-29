package codegym.controller;

import codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping(value = "")
    public String search(){
        return "search";
    }

    @Autowired
    DictionaryService dictionaryService;
    @PostMapping(value = "find")
    public String find(@RequestParam String word, Model model){
        if (dictionaryService.find(word) == null){
            model.addAttribute("mess", "No result matched");
            return "search";
        } else {
            model.addAttribute("result", dictionaryService.find(word));
            return "search";
        }
    }
}
