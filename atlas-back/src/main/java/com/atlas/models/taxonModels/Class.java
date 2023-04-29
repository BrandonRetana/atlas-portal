package com.atlas.models.taxonModels;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Class")
public class Class extends Taxon{

    public Class(String scientificName, String author, int publicationYear, long ancestorID) {
        super(scientificName, author, publicationYear);
        this.ancestorID = ancestorID;
    }

    public Class(){}

     
    public long getAncestorID() {
        return super.getAncestorID();
    }

    public void setAncestorID(long ancestorID) {
        super.setAncestorID(ancestorID);
          
    }

    public String getScientificName() {
        return super.getScientificName();
    }

    public void setScientificName(String scientificName) {
        super.setScientificName(scientificName);
    }

    public String getAuthor() {
        return super.getAuthor();
    }

    public void setAuthor(String author) {
         super.setAuthor(author);
    }

    public int getPublicationYear() {
        return super.getPublicationYear();
    }

    public void setPublicattonYear(int publicationYear) {
        super.setPublicationYear(publicationYear);
    }

}