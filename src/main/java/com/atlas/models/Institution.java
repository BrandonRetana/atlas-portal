package com.atlas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "institution")
public class Institution extends Owner{

    public Institution(long id, String name, String country, String phone, String mail) {
        super(id, name, country, phone, mail);

    }

    public Institution(){}

    @Column(name = "web_site")
    private String webSite;
    
    
}
