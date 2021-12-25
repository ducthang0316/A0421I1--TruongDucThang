package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.impl.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("list", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("mess", "Add new song successfully");
            return "redirect:/song";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable("id") Long id,  Model model){
        Optional<Song> song =  songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "edit";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("mess", "Update song successfully");
            return "redirect:/song";
        }
    }
}
