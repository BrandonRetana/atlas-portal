package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Family")
public class Family extends Taxon{

    public Family(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Family");
    }

    public Family(){}
   
}