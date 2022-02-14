package com.wolanin.watchos.controller;

import com.wolanin.watchos.data.Note;
import com.wolanin.watchos.data.Tag;
import com.wolanin.watchos.form.NoteForm;
import com.wolanin.watchos.repo.NoteRepository;
import com.wolanin.watchos.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;


import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller("/home")
public class HomeController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("date", getCurrentTime());
        NoteForm noteForm = new NoteForm();
        model.addAttribute("noteForm", noteForm);
        List<Note> existingList = noteRepository.findAllByUser(user);
        model.addAttribute("noteList", existingList);
        model.addAttribute("note", new Note());
        return "home";
    }

    @PostMapping("/home")
    public String postForm(@ModelAttribute NoteForm noteForm, @AuthenticationPrincipal User user, SessionStatus sessionStatus) {
        List<Tag> tagListToSave = convertTags(noteForm.getTags());
        Note noteToSave = new Note(LocalDateTime.now(), noteForm.getContent(), user);
        noteToSave.setTagList(tagListToSave);
        noteRepository.save(noteToSave);
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String deleteNote(@ModelAttribute("id") Long note) {
        noteRepository.deleteById(note);
        return "redirect:/home";
    }

    private String getCurrentTime() {
        LocalDateTime date = LocalDateTime.now();
        Locale locale = new Locale("pl", "PL");
        return date.getDayOfMonth() + " " + date.getMonth().getDisplayName(TextStyle.FULL, locale) + " " + date.getYear();
    }

    private List<Tag> convertTags(String tagString){
        List<Tag> tagList = new ArrayList<>();
        String[] stringList = tagString.split("[ ,]+");
        for (String x :
                stringList) {
            tagList.add(new Tag(x));
        }
        return tagList;
    }

}
