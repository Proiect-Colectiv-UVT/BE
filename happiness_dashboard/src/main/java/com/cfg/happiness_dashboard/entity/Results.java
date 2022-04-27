package com.cfg.happiness_dashboard.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "results")
public class Results  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, updatable = false)
    private int rating;
    @Column(updatable = false)
    private String comment;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date date;
    
    public Results(int rating, String comment, Date date) {
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public Results() {
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

    @Override
    public String toString() {
        return "Results [comment=" + comment + ", date=" + date + ", rating=" + rating + "]";
    }
    
}
