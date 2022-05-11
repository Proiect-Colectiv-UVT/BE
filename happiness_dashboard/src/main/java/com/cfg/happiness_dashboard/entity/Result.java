package com.cfg.happiness_dashboard.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "result")
public class Result  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, updatable = false)
    private int rating;
    @Column(updatable = false)
    private String comment;
    @Column(nullable = false, updatable = false)
    private Date date;


    public Result(long id, int rating, String comment, Date date) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public Result() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Result [comment=" + comment + ", date=" + date + ", id=" + id + ", rating=" + rating + "]";
    }
    
}
