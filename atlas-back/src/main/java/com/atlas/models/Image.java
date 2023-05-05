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
    private static int count = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @NotNull
    @Size(max = 500)
    private String description;

    @NotNull
    @Column(name = "creation_date")
    private String creationDate;

    @ElementCollection
    @NotNull
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

    public Image() {
        count++;
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

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public static int getCount() {
        return count;
    }
}