package com.cfg.happiness_dashboard.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "polls")
public class Poll implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private Date expiryDate;

    @OneToMany(targetEntity = Result.class, cascade = CascadeType.ALL)
    @JoinColumn(name="idPoll", nullable=false, referencedColumnName = "id")
    private List <Result> pollResults;

    public Poll(long id, String title, String description, Date expiryDate, List<Result> pollResults) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiryDate = expiryDate;
        this.pollResults = pollResults;
    }

    
    public Poll() {
    }

    public long getId() {
        return id;
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


    public List<Result> getPollResults() {
        return pollResults;
    }


    public void setPollResults(List<Result> pollResults) {
        this.pollResults = pollResults;
    }


    @Override
    public String toString() {
        return "Poll [description=" + description + ", expiryDate=" + expiryDate + ", id=" + id + ", pollResults="
                + pollResults + ", title=" + title + "]";
    }


}
