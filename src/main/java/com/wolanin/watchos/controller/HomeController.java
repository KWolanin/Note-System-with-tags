package com.wolanin.watchos.controller;

import com.wolanin.watchos.data.Note;
import com.wolanin.watchos.form.NoteForm;
import com.wolanin.watchos.repo.NoteRepository;
import com.wolanin.watchos.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Controller("/home")
public class HomeController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("date", getCurrentTime());
        NoteForm noteForm = new NoteForm();
        model.addAttribute("note", noteForm);
        List<Note> existingList = noteRepository.findAllByUser(user);
        model.addAttribute("noteList", existingList);
        model.addAttribute("note", new Note());
        return "home";
    }

    @PostMapping("/home")
    public String postForm(@ModelAttribute NoteForm noteForm, @AuthenticationPrincipal User user, SessionStatus sessionStatus) {
        Note noteToSave = new Note(LocalDateTime.now(), noteForm.getContent(), user);
        noteRepository.save(noteToSave);
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String deleteNote(@ModelAttribute("id") Long note) {
        System.out.println(note);
        noteRepository.deleteById(note);
        return "redirect:/home";
    }

    private String getCurrentTime() {
        LocalDateTime date = LocalDateTime.now();
        return "Today is: " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear();
    }
}
