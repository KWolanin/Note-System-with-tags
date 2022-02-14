package com.wolanin.watchos.data;

import javax.persistence.*;

@Entity(name = "Tag")
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
