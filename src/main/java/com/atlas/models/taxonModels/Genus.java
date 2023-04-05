package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Genus")
public class Genus extends Taxon{

    public Genus(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Genus");
    }

    public Genus(){}
   
}