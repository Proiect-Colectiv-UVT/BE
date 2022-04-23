package com.cfg.happiness_dashboard.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    
    
    
    public User(long id, String name) {
        this.id = id;
        this.name = name;
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



    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    
}
