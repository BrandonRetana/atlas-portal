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
@RequestMapping()
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

    @PostMapping("/create/taxon")
    public @ResponseBody Map<String, String> getTaxon(@RequestBody Map<String, Object> data,   RedirectAttributes redirectAttributes){

        Map<String, String> response = new HashMap<>();
        String type = (String) data.get("typeClass");
        System.out.println("llega");

        if (data.get("id") != null){ //update
            switch (type) {
                case "kingdom":
                    Kingdom kingdom = new Kingdom();
                    kingdom.setScientificName((String) data.get("scientificName"));
                    kingdom.setAuthor((String) data.get("author"));
                    kingdom.setPublicationYear((int) data.get("publicationYear"));
                    kingdom.setId((long) data.get("id"));
                    kingdomService.updateKingdom(kingdom);
                    break;

                case "genus":
                    Genus genus = new Genus((String) data.get("scientificName"),(String) data.get("author"), (int) data.get("publicationYear"), (long) data.get("ancestorID"));
                    genus.setId((long) data.get("id"));
                    genusService.updateGenus(genus);
                    break;

                case "phylum":
                    Phylum phylum = new Phylum();
                    System.out.println("llegaaaaaaa");
                    phylum.setScientificName((String) data.get("scientificName"));
                    phylum.setAuthor((String) data.get("author"));
                    phylum.setPublicationYear((int) data.get("publicationYear"));
                    phylum.setAncestorID(55);
                    phylum.setId((long) data.get("id"));
                    System.out.println("phylum");
                    phylumService.updatePhylum(phylum);
                    break;

                case "class":
                    Class class1 = new Class();
                    class1.setScientificName((String) data.get("scientificName"));
                    class1.setAuthor((String) data.get("author"));
                    class1.setPublicationYear((int) data.get("publicationYear"));
                    class1.setAncestorID((long) data.get("ancestorID"));
                    class1.setId((long) data.get("id"));
                    classService.updateClass(class1);
                    break;

                case "order":
                    Order order = new Order();
                    order.setScientificName((String) data.get("scientificName"));
                    order.setAuthor((String) data.get("author"));
                    order.setPublicationYear((int) data.get("publicationYear"));
                    order.setAncestorID((long) data.get("ancestorID"));
                    order.setId((long) data.get("id"));
                    orderService.updateOrder(order);
                    break;

                case "famiy":
                    Family family = new Family();
                    family.setScientificName((String) data.get("scientificName"));
                    family.setAuthor((String) data.get("author"));
                    family.setPublicationYear((int) data.get("publicationYear"));
                    family.setAncestorID((long) data.get("ancestorID"));
                    family.setId((long) data.get("id"));
                    familyService.updateFamily(family);
                    break;

                case "species":
                    Species species = new Species();
                    species.setScientificName((String) data.get("scientificName"));
                    species.setAuthor((String) data.get("author"));
                    species.setPublicationYear((int) data.get("publicationYear"));
                    species.setAncestorID((long) data.get("ancestorID"));
                    species.setId((long) data.get("id"));
                    speciesService.updateSpecies(species);
                    break;

                default :
                    response.put("NO", "update");
                    return ResponseEntity.ok(response).getBody();
            }
        response.put("YES", "update");
        return ResponseEntity.ok(response).getBody();

        }else{
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
                    System.out.println("llegaaaaaaa");
                    phylum.setScientificName((String) data.get("scientificName"));
                    phylum.setAuthor((String) data.get("author"));
                    phylum.setPublicationYear((int) data.get("publicationYear"));
                    phylum.setAncestorID(55);
                    System.out.println("phylum");
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
                    response.put("NO", "created");
                    return ResponseEntity.ok(response).getBody();
            }
        }
        response.put("YES", "created");
        return ResponseEntity.ok(response).getBody();
    }

    @RequestMapping("/list/kingdoms")
    public @ResponseBody Map<String, Object> getAllKingdoms() {
        Map<String, Object> response = new HashMap<>();
        List<Kingdom> kingdoms = kingdomService.getAllKingdoms();
        response.put("kingdoms", kingdoms);
        return response;
    }

    @RequestMapping("/list/phylums")
    public @ResponseBody Map<String, Object> getAllPhylums() {
        Map<String, Object> response = new HashMap<>();
        List<Phylum> phylums = phylumService.getAllPhylums();
        response.put("phylums", phylums);
        return response;
    }

    @RequestMapping("/list/classes")
    public @ResponseBody Map<String, Object> getAllClasses() {
        Map<String, Object> response = new HashMap<>();
        List<Class> classes = classService.getAllClasses();
        response.put("classes", classes);
        return response;
    }

    @RequestMapping("/list/orders")
    public @ResponseBody Map<String, Object> getAllOrders() {
        Map<String, Object> response = new HashMap<>();
        List<Order> orders = orderService.getAllOrders();
        response.put("orders", orders);
        return response;
    }

    @RequestMapping("/list/families")
    public @ResponseBody Map<String, Object> getAllFamilies() {
        Map<String, Object> response = new HashMap<>();
        List<Family> families = familyService.getAllFamilies();
        response.put("families", families);
        return response;
    }

    @RequestMapping("/list/genus")
    public @ResponseBody Map<String, Object> getAllGenus() {
        Map<String, Object> response = new HashMap<>();
        List<Genus> genus = genusService.getAllGenus();
        response.put("genus", genus);
        return response;
    }

    @RequestMapping("/list/species")
    public @ResponseBody Map<String, Object> getAllSpecies() {
        Map<String, Object> response = new HashMap<>();
        List<Species> species = speciesService.getAllSpecies();
        response.put("species", species);
        return response;
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
