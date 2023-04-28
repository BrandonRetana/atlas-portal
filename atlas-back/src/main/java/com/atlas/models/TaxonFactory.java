package com.atlas.models;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atlas.service.*;
import com.atlas.models.taxonModels.*;


public class TaxonFactory {

    @Autowired
    private  KingdomService kingdomService;
    @Autowired
    private  PhylumService phylumService;
    @Autowired
    private  ClassService classService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private  FamilyService familyService;
    @Autowired
    private  GenusService genusService;
    @Autowired
    private  SpeciesService speciesService;


    public void createTaxon(@RequestBody Map<String, Object> data){
        String type = (String) data.get("typeClass");
        System.out.println(type);
        String scientificName = (String) data.get("scientificName");
        System.out.println(scientificName);
        String author = (String) data.get("author");
        System.out.println(author);
        int publicationYear = (int) data.get("publicationYear");
        System.out.println(publicationYear);
        String ancestorID = (String) data.get("ancestorID");
        System.out.println(ancestorID);

    
        switch (type) {
            case "kingdom":
                Kingdom kingdom = new Kingdom((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"));
                kingdomService.addKingdom(kingdom);
                break;

            case "genus":
                Genus genus = new Genus((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                genusService.addGenus(genus);
                break;    

            case "phylum":
                System.out.println("llegue aqui");
                Phylum phylum = new Phylum(scientificName,author,publicationYear,23);
                System.out.println("llegue aqui 2");
                phylumService.addPhylum(phylum);
                System.out.println("AGRUEGUE");
                break;
            
            case "class":
                TClass class1 = new TClass((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                classService.addClass(class1);
                break;

            case "order":
                Order order = new Order((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                orderService.addOrder(order);
                break;

            case "famiy":
                Family family = new Family((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                familyService.addFamily(family);
                break;

            case "species":
                Species species = new Species((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                speciesService.addSpecies(species);
                break;

            default:
                Kingdom kingdom1 = new Kingdom((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"));
                kingdomService.addKingdom(kingdom1);
                break;
        }
    }
}
