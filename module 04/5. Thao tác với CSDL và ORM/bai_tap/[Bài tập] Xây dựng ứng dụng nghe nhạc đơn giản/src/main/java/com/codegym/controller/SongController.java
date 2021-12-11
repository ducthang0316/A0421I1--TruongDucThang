package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;
    @GetMapping("")
    public String show(Model model){
        model.addAttribute("list", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate (Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "song") Song song, RedirectAttributes redirect){
        songService.save(song);
        redirect.addFlashAttribute("mess", "Created new song successfully");
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable Long id){
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(Song song, RedirectAttributes redirectAttributes){
        songService.update(song);
        redirectAttributes.addFlashAttribute("mess", "Updated song successfully");
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable Long id){
        model.addAttribute("song", songService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String remove(Song song, RedirectAttributes redirectAttributes){
        songService.delete(song);
        redirectAttributes.addFlashAttribute("mess", "Deleted song successfully");
        return "redirect:/song";
    }
}
