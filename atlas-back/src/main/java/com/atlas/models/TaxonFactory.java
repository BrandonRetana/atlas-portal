package com.atlas.models;

import com.atlas.models.taxonModels.Class;
import com.atlas.models.taxonModels.Genus;
import com.atlas.models.taxonModels.Kingdom;
import com.atlas.models.taxonModels.Order;
import com.atlas.models.taxonModels.Phylum;
import com.atlas.models.taxonModels.Taxon;

public class TaxonFactory {
    public static Taxon createTaxon(String key){
        Taxon t;
        switch (key) {
            case "kingdom":
                t = new Kingdom();
                break;

            case "phylum":
                t = new Phylum();
                break;
            
            case "class":
                t = new Class();
                break;

            case "order":
                t = new Order();
                break;

            case "famiy":
                t = new Genus();
                break;

            case "specie":
                t = new Genus();
                break;

            default:
            t = new Kingdom();
                break;
        }

        return t;
    }
}
