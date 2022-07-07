package com.example.securingweb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
//    Date date;
    String text;
    Long userId;

    public JournalEntry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }
}
