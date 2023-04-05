package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Kingdom")
public class Kingdom extends Taxon{

    public Kingdom(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Kingdom");
    }

    public Kingdom(){}


}