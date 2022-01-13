package com.wolanin.watchos.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Note")
@Table(name = "User")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    private LocalDateTime creationDate;
    private String content;

    public Note() {
    }

    public Note(String content, LocalDateTime creationDate) {
        this.content = content;
        this.creationDate = creationDate;

    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    private User user;

    public Note(LocalDateTime creationDate, String content, User user) {
        this.creationDate = creationDate;
        this.content = content;
        this.user = user;
    }

    public void setUser(User user) {
    }

    public User getUser() {
        return user;
    }
}
