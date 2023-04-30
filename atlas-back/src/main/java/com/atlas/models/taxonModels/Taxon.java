package com.atlas.models.taxonModels;

import javax.validation.constraints.NotNull;

import jakarta.persistence.*;
import org.hibernate.mapping.Set;

import java.util.HashSet;

@Entity
@Table(name = "taxon")
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
    private int publicationYear;

    @Column(name = "taxon_acestor_id")
    public long ancestorID;


    public Taxon( @NotNull String scientificName, String author, int publicationYear) {
        this.scientificName = scientificName;
        this.author = author;
        this.publicationYear = publicationYear;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int l) {
        this.publicationYear = l;
    }

    public long getAncestorID() {
        return ancestorID;
    }

    public void setAncestorID(long ancestorID) {
        this.ancestorID = ancestorID;
    }


    
    @Override
    public String toString() {
        return "Taxon [id=" + id + ", scientificName=" + scientificName + ", author=" + author + ", publicationYear="
                + publicationYear + "]";
    }

    


}
