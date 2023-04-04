package com.atlas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person extends Owner{

    public Person(long id, String name, String country, String phone, String mail) {
        super(id, name, country, phone, mail);
    }

    public Person (){}

    @Column(name = "last_name")
    private String lastName;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
}
