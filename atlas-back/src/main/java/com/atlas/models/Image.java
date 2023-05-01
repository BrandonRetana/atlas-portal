package com.atlas.models;
import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

import com.atlas.models.taxonModels.Taxon;


@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 500)
    private String description;

    @NotNull
    @Column(name = "creation_date")
    private String creationDate;

    @ElementCollection
    private List<String> keywords;

    @OneToOne
    private Person author;

    @OneToOne
    private Owner owner;

    @NotNull
    private String license;

    @ManyToMany
    private List<Taxon> taxon;

    private String path;

    public Image (){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }


    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Taxon> getTaxon() {
        return taxon;
    }

    public void setTaxon(List<Taxon> taxon) {
        this.taxon = taxon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public void setKeywords(List<String> keywords) {
    }

    public void setOwner(Owner owner1) {
    }
}
