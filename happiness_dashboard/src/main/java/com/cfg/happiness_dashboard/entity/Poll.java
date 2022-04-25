package com.cfg.happiness_dashboard.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private Date expiryDate;

    public Poll(long id, String title, String description, Date expiryDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiryDate = expiryDate;
    }

    public Poll() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Poll [description=" + description + ", expiryDate=" + expiryDate + ", id=" + id
                + ", title=" + title + "]";
    }

}
