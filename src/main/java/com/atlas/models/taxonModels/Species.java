package com.atlas.models.taxonModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Species")
public class Species extends Taxon{

    public Species(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Species");
    }

    public Species(){}
   
}