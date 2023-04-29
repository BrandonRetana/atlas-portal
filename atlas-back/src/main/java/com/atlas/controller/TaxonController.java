package com.atlas.controller;

import java.lang.instrument.ClassFileTransformer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import com.atlas.service.*;
import com.atlas.models.taxonModels.*;
import com.atlas.models.taxonModels.Class;


@RestController
@RequestMapping("/taxons")
public class TaxonController {

    @Autowired
    private KingdomService kingdomService;
    @Autowired
    private PhylumService phylumService;
    @Autowired
    private ClassService classService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private GenusService genusService;
    @Autowired
    private SpeciesService speciesService;


    @PostMapping("/create")
    public @ResponseBody Map<String, String> getTaxon(@RequestBody Map<String, Object> data,   RedirectAttributes redirectAttributes){

        Map<String, String> response = new HashMap<>();

        try {
            String type = (String) data.get("typeClass");
            System.out.println("llega");

            switch (type) {
                case "kingdom":
                    Kingdom kingdom = new Kingdom();
                    kingdom.setScientificName((String) data.get("scientificName"));
                    kingdom.setAuthor((String) data.get("author"));
                    kingdom.setPublicationYear((int) data.get("publicationYear"));
                    kingdomService.addKingdom(kingdom);
                    break;

                case "genus":
                    Genus genus = new Genus((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                    genusService.addGenus(genus);
                    break;    

                case "phylum":
                    Phylum phylum = new Phylum();
                    phylum.setScientificName((String) data.get("scientificName"));
                    phylum.setAuthor((String) data.get("author"));
                    phylum.setPublicationYear((int) data.get("publicationYear"));
                    phylum.setAncestorID((long) data.get("ancestorID"));
                    phylumService.addPhylum(phylum);
                    break;
                
                case "class":
                    Class class1 = new Class();
                    class1.setScientificName((String) data.get("scientificName"));
                    class1.setAuthor((String) data.get("author"));
                    class1.setPublicationYear((int) data.get("publicationYear"));
                    class1.setAncestorID((long) data.get("ancestorID"));
                    classService.addClass(class1);
                    break;

                case "order":
                    Order order = new Order();
                    order.setScientificName((String) data.get("scientificName"));
                    order.setAuthor((String) data.get("author"));
                    order.setPublicationYear((int) data.get("publicationYear"));
                    order.setAncestorID((long) data.get("ancestorID"));
                    orderService.addOrder(order);
                    break;

                case "famiy":
                    Family family = new Family();
                    family.setScientificName((String) data.get("scientificName"));
                    family.setAuthor((String) data.get("author"));
                    family.setPublicationYear((int) data.get("publicationYear"));
                    family.setAncestorID((long) data.get("ancestorID"));
                    familyService.addFamily(family);
                    break;

                case "species":
                    Species species = new Species();
                    species.setScientificName((String) data.get("scientificName"));
                    species.setAuthor((String) data.get("author"));
                    species.setPublicationYear((int) data.get("publicationYear"));
                    species.setAncestorID((long) data.get("ancestorID"));
                    speciesService.addSpecies(species);
                    break;

                default:
                    Kingdom kingdom1 = new Kingdom();
                    kingdom1.setScientificName((String) data.get("scientificName"));
                    kingdom1.setAuthor((String) data.get("author"));
                    kingdom1.setPublicationYear((int) data.get("publicationYear"));
                    kingdomService.addKingdom(kingdom1);
                    break;
            }

            response.put("YES", "created");
            return ResponseEntity.ok(response).getBody();

        } catch (Exception e) {
            response.put("NO", "not created");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response).getBody();
        }
    }

    @RequestMapping("/list/kingdoms")
    public List<Kingdom> getAllKingdoms() {
        return kingdomService.getAllKingdoms();
    }

    @RequestMapping("/list/phylums")
    public List<Phylum> getAllPhylums() {
        return phylumService.getAllPhylums();
    }

    @RequestMapping("/list/classes")
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @RequestMapping("/list/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping("/list/families")
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    @RequestMapping("/list/genus")
    public List<Genus> getAllGenus() {
        return genusService.getAllGenus();
    }

    @RequestMapping("/list/species")
    public List<Species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    @RequestMapping("/list")
    public List<Taxon> getAllTaxons() {
        List<Taxon> taxons = new ArrayList<>();
        taxons.addAll(kingdomService.getAllKingdoms());
        taxons.addAll(phylumService.getAllPhylums());
        taxons.addAll(classService.getAllClasses());
        taxons.addAll(orderService.getAllOrders());
        taxons.addAll(familyService.getAllFamilies());
        taxons.addAll(genusService.getAllGenus());
        taxons.addAll(speciesService.getAllSpecies());
        return taxons;
    }

    @RequestMapping("/{id}")
    public Taxon getTaxon(@PathVariable("id") long id) {
        Taxon taxon = null;
        taxon = kingdomService.getKingdomById(id);
        if (taxon == null) {
            taxon = phylumService.getPhylumById(id);
            if (taxon == null) {
                taxon = classService.getClassById(id);
                if (taxon == null) {
                    taxon = orderService.getOrderById(id);
                    if (taxon == null) {
                        taxon = familyService.getFamilyById(id);
                        if (taxon == null) {
                            taxon = genusService.getGenusById(id);
                            if (taxon == null) {
                                taxon = speciesService.getSpeciesById(id);
                            }
                        }
                    }
                }
            }
        }
        return taxon;
    }

    @PutMapping("/update/{id}")
    public void updateTaxon(@PathVariable("id") long id, @RequestBody Taxon taxon) {
        Taxon taxon1 = getTaxon(id);
        if (taxon1 != null) {
            taxon1.setScientificName(taxon.getScientificName());
            taxon1.setAuthor(taxon.getAuthor());
            taxon1.setPublicationYear(taxon.getPublicationYear());
            taxon1.setAncestorID(taxon.getAncestorID());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaxon(@PathVariable("id") long id) {
        Taxon taxon = getTaxon(id);
        if (taxon != null) {
            if (taxon instanceof Kingdom) {
                kingdomService.deleteKingdom(id);
            } else if (taxon instanceof Phylum) {
                phylumService.deletePhylum(id);
            } else if (taxon instanceof Class) {
                classService.deleteClass(id);
            } else if (taxon instanceof Order) {
                orderService.deleteOrder(id);
            } else if (taxon instanceof Family) {
                familyService.deleteFamily(id);
            } else if (taxon instanceof Genus) {
                genusService.deleteGenus(id);
            } else if (taxon instanceof Species) {
                speciesService.deleteSpecies(id);
            }
        }
    }
}
