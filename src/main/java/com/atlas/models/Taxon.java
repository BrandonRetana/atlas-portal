package com.atlas.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxon")
public class Taxon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "scientific_name")
    private String scientificName;

    @OneToOne
    private Person author;

    @Column(name = "publication_year")
    private Date publicattionYear;

    @Column(name = "taxon_acestor_id")
    public long acestorID;

    public Taxon(long id, String scientificName, Person author, Date publicattionYear, long acestorID) {
        this.id = id;
        this.scientificName = scientificName;
        this.author = author;
        this.publicattionYear = publicattionYear;
        this.acestorID = acestorID;
    }

    public Taxon(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Date getPublicattionYear() {
        return publicattionYear;
    }

    public void setPublicattionYear(Date publicattionYear) {
        this.publicattionYear = publicattionYear;
    }

    public long getAcestorID() {
        return acestorID;
    }

    public void setAcestorID(long acestorID) {
        this.acestorID = acestorID;
    }

}
