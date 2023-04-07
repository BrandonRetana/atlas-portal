package com.atlas.models.taxonModels;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Name;

import jakarta.persistence.Table;

@Entity
@Table(name = "taxon")
public abstract class Taxon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Name
    @NotNull
    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_year")
    private int publicattionYear;

    @Column(name = "taxon_acestor_id")
    public long ancestorID;

    @Column(name = "taxon_type")
    public String taxon_type;

    public Taxon(long id, String scientificName, String author, int publicattionYear, long ancestorID, String taxon_type) {
        this.id = id;
        this.scientificName = scientificName;
        this.author = author;
        this.publicattionYear = publicattionYear;
        this.ancestorID = ancestorID;
        this.taxon_type = taxon_type;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicattionYear() {
        return publicattionYear;
    }

    public void setPublicattionYear(int publicattionYear) {
        this.publicattionYear = publicattionYear;
    }

    public long getAcestorID() {
        return ancestorID;
    }



}
