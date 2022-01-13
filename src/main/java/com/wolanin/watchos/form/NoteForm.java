package com.wolanin.watchos.form;

import org.springframework.stereotype.Component;

@Component
public class NoteForm {

    private String content;

    public NoteForm() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
