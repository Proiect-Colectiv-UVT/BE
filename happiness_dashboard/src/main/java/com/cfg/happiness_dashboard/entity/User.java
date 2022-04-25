package com.cfg.happiness_dashboard.entity;

import java.io.Serializable;
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
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private long id;
    @Column(nullable = false)
    private String name;
    
    @OneToMany(targetEntity = Poll.class, cascade = CascadeType.ALL)
    @JoinColumn(name="idCreator", nullable=false, referencedColumnName = "id")
    private List <Poll> pollsCreated;

    
    public User(long id, String name, List<Poll> pollsCreated) {
        this.id = id;
        this.name = name;
        this.pollsCreated = pollsCreated;
    }



    public User() {
    }
    
    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public List<Poll> getPollsCreated() {
        return pollsCreated;
    }



    public void setPollsCreated(List<Poll> pollsCreated) {
        this.pollsCreated = pollsCreated;
    }



    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", pollsCreated=" + pollsCreated + "]";
    }

    
}
