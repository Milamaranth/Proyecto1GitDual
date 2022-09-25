package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String name;
    private Date birth_date;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    private Integer type_id;

    public Integer getId(){
        return id;
    }
    public void setId(Integer newId){
        id = newId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
    public Integer getType_id() {
        return type_id;
    }
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
    @Override
    public String toString() {
        return "Pet [name=" + name + ", type_id=" + type_id + "]";
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
