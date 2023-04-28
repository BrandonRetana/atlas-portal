package com.atlas.models.taxonModels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass

public abstract class Taxon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_year")
    private int publicattionYear;



    public Taxon( @NotNull String scientificName, String author, int publicattionYear) {
        this.scientificName = scientificName;
        this.author = author;
        this.publicattionYear = publicattionYear;
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

    public void setPublicattionYear(long l) {
        this.publicattionYear = (int) l;
    }

    @Override
    public String toString() {
        return "Taxon [id=" + id + ", scientificName=" + scientificName + ", author=" + author + ", publicattionYear="
                + publicattionYear + "]";
    }

    


}
