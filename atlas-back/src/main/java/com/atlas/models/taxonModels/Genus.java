package com.atlas.models.taxonModels;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Genus")
public class Genus extends Taxon{

    @Column(name = "taxon_acestor_id")
    public long ancestorID;

    public Genus(String scientificName, String author, int publicattionYear, long ancestorID) {
        super(scientificName, author, publicattionYear);
        this.ancestorID = ancestorID;
    }

    public Genus(){}
   
}