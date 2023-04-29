package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "kingdom")
public class Kingdom extends Taxon{

    public Kingdom(String scientificName, String author, int publicationYear) {
        super( scientificName, author, publicationYear);
    }

    public Kingdom(){}

    @Override
    public String getAuthor() {
        // TODO Auto-generated method stub
        return super.getAuthor();
    }

    @Override
    public long getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public int getPublicationYear() {
        // TODO Auto-generated method stub
        return super.getPublicationYear();
    }

    @Override
    public String getScientificName() {
        // TODO Auto-generated method stub
        return super.getScientificName();
    }

    @Override
    public void setAuthor(String author) {
        // TODO Auto-generated method stub
        super.setAuthor(author);
    }

    @Override
    public void setId(long id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }



    @Override
    public void setPublicationYear(int l) {
        // TODO Auto-generated method stub
        super.setPublicationYear(l);
    }

    @Override
    public void setScientificName(String scientificName) {
        // TODO Auto-generated method stub
        super.setScientificName(scientificName);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    


}