package com.wolanin.watchos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.format.DateTimeFormatter;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("date", getCurrentTime());
        NoteForm noteForm = new NoteForm();
        model.addAttribute("note", noteForm);
        List<Note> existingList = noteRepository.findAll();
        model.addAttribute("noteList", existingList);
        return "home";
    }

    @PostMapping("/")
    public String postForm(@ModelAttribute NoteForm noteForm) {
        Note noteToSave = new Note(noteForm.getContent(), LocalDateTime.now());
        noteRepository.save(noteToSave);
        return "redirect:/";
    }

    private String getCurrentTime() {
        LocalDateTime date = LocalDateTime.now();
        return "Today is: " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
    }
}
