package com.atlas.models.taxonModels;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Family")
public class Family extends Taxon{


    public Family(String scientificName, String author, int publicattonYear, long ancestorID) {
        super(scientificName, author, publicattonYear);
        this.ancestorID = ancestorID;
    }

    public Family(){}

     
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