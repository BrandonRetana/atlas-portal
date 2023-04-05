package com.atlas.models.taxonModels;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Order")
public class Order extends Taxon{

    public Order(long id, String scientificName, String author, int publicattionYear, long ancestorID) {
        super(id, scientificName, author, publicattionYear, ancestorID, "Order");
    }

    public Order(){}

}