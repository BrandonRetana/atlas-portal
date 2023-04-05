package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Phylum")
public class Phylum extends Taxon{

    public Phylum(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Phylum");
    }

    public Phylum(){}

}