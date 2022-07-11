package com.example.securingweb.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Entity
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String dateAndTime;
    String text;
    Long userId;

    public JournalEntry(String text, Long userId) {
        this.text = text;
        this.userId = userId;
    }

    public JournalEntry() {
    }

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }
}
