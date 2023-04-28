package com.atlas.models.taxonModels;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Family extends Taxon{
    @Column(name = "taxon_acestor_id")
    public long ancestorID;

    public Family(String scientificName, String author, int publicattionYear, long ancestorID) {
        super(scientificName, author, publicattionYear);
        this.ancestorID = ancestorID;
    }

    public Family(){}
   
}