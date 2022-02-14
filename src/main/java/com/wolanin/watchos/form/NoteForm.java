package com.wolanin.watchos.form;

import org.springframework.stereotype.Component;

@Component
public class NoteForm {

    private String content;
    private String tags;

    public NoteForm() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
