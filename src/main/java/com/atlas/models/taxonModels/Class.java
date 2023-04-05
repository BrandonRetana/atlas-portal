package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Class")
public class Class extends Taxon{

    public Class(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Class");
    }

    public Class(){}

}