package com.atlas.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
    public @ResponseBody Map<String, String> createTaxon(@RequestBody Map<String, Object> data,   RedirectAttributes redirectAttributes){

        Map<String, String> response = new HashMap<>();
        String type = (String) data.get("typeClass");

        if (data.get("id") != ""){ //update
            long id2;
            switch (type) {
                case "kingdom":
                    Kingdom kingdom = new Kingdom();
                    kingdom.setScientificName((String) data.get("scientificName"));
                    kingdom.setAuthor((String) data.get("author"));
                    kingdom.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    id2 = Long.parseLong((String) data.get("id"));
                    kingdom.setId(id2);
                    kingdomService.updateKingdom(kingdom);
                    break;

                case "genus":
                    Genus genus = new Genus();
                    genus.setScientificName((String) data.get("scientificName"));
                    genus.setAuthor((String) data.get("author"));
                    genus.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    genus.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    genus.setId(id2);
                    genusService.updateGenus(genus);
                    break;

                case "phylum":
                    Phylum phylum = new Phylum();
                    phylum.setScientificName((String) data.get("scientificName"));
                    phylum.setAuthor((String) data.get("author"));
                    phylum.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    phylum.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    phylum.setId(id2);
                    System.out.println("phylum");
                    phylumService.updatePhylum(phylum);
                    break;

                case "class":
                    Class class1 = new Class();
                    class1.setScientificName((String) data.get("scientificName"));
                    class1.setAuthor((String) data.get("author"));
                    class1.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    class1.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    class1.setId(id2);
                    classService.updateClass(class1);
                    break;

                case "order":
                    Order order = new Order();
                    order.setScientificName((String) data.get("scientificName"));
                    order.setAuthor((String) data.get("author"));
                    order.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    order.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    order.setId(id2);
                    orderService.updateOrder(order);
                    break;

                case "family":
                    Family family = new Family();
                    family.setScientificName((String) data.get("scientificName"));
                    family.setAuthor((String) data.get("author"));
                    family.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    family.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    family.setId(id2);
                    familyService.updateFamily(family);
                    break;

                case "species":
                    Species species = new Species();
                    species.setScientificName((String) data.get("scientificName"));
                    species.setAuthor((String) data.get("author"));
                    species.setPublicationYear(Integer.parseInt((String) data.get("publicationYear")));
                    species.setAncestorID(Integer.parseInt((String) data.get("ancestorID")));
                    id2 = Long.parseLong((String) data.get("id"));
                    species.setId(id2);
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
                    Genus genus = new Genus();
                    genus.setScientificName((String) data.get("scientificName"));
                    genus.setAuthor((String) data.get("author"));
                    genus.setPublicationYear((int) data.get("publicationYear"));
                    genus.setAncestorID((int) data.get("ancestorID"));
                    genusService.addGenus(genus);
                    break;

                case "phylum":
                    Phylum phylum = new Phylum();
                    phylum.setScientificName((String) data.get("scientificName"));
                    phylum.setAuthor((String) data.get("author"));
                    phylum.setPublicationYear((int) data.get("publicationYear"));
                    phylum.setAncestorID((int) data.get("ancestorID"));
                    System.out.println("phylum");
                    phylumService.addPhylum(phylum);
                    break;

                case "class":
                    Class class1 = new Class();
                    class1.setScientificName((String) data.get("scientificName"));
                    class1.setAuthor((String) data.get("author"));
                    class1.setPublicationYear((int) data.get("publicationYear"));
                    class1.setAncestorID((int) data.get("ancestorID"));
                    classService.addClass(class1);
                    break;

                case "order":
                    Order order = new Order();
                    order.setScientificName((String) data.get("scientificName"));
                    order.setAuthor((String) data.get("author"));
                    order.setPublicationYear((int) data.get("publicationYear"));
                    order.setAncestorID((int) data.get("ancestorID"));
                    orderService.addOrder(order);
                    break;

                case "family":
                    Family family = new Family();
                    family.setScientificName((String) data.get("scientificName"));
                    family.setAuthor((String) data.get("author"));
                    family.setPublicationYear((int) data.get("publicationYear"));
                    family.setAncestorID((int) data.get("ancestorID"));
                    familyService.addFamily(family);
                    break;

                case "species":
                    Species species = new Species();
                    species.setScientificName((String) data.get("scientificName"));
                    species.setAuthor((String) data.get("author"));
                    species.setPublicationYear((int) data.get("publicationYear"));
                    species.setAncestorID((int) data.get("ancestorID"));
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


    @RequestMapping("/taxon/{id}")
    public @ResponseBody Map<String, String> getTaxon(@PathVariable("id") long id) {
        Map<String, String> response = new HashMap<>();
        Taxon taxon = null;
        if(kingdomService.isPresent(id)){
            taxon = kingdomService.getKingdomById(id);
        }else if(phylumService.isPresent(id)){
            taxon = phylumService.getPhylumById(id);
        }else if(classService.isPresent(id)){
            taxon = classService.getClassById(id);
        }else if(orderService.isPresent(id)){
            taxon = orderService.getOrderById(id);
        }else if(familyService.isPresent(id)){
            taxon = familyService.getFamilyById(id);
        }else if(genusService.isPresent(id)){
            taxon = genusService.getGenusById(id);
        }else if(speciesService.isPresent(id)){
            taxon = speciesService.getSpeciesById(id);
        }

        if (taxon != null) {
            response.put("id", String.valueOf(taxon.getAncestorID()));
            response.put("scientificName", taxon.getScientificName());
            response.put("author", taxon.getAuthor());
            response.put("publicationYear", String.valueOf(taxon.getPublicationYear()));
            response.put("ancestorID", String.valueOf(taxon.getAncestorID()));
            response.put("typeClass", taxon.getClass().getSimpleName().toLowerCase());
            Taxon t = getTaxonbyId(taxon.getAncestorID());
            if(t != null){
                String name = t.getScientificName();
                response.put("ancestorName", name);
            }
            else{
                response.put("ancestorName", "Sin ancestro");
            }
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaxon(@PathVariable("id") long id) {
        Taxon taxon = getTaxonbyId(id);
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

    public Taxon getTaxonbyId(@PathVariable("id") long id) {
        Taxon taxon = null;
        if(kingdomService.isPresent(id)){
            taxon = kingdomService.getKingdomById(id);
        }else if(phylumService.isPresent(id)){
            taxon = phylumService.getPhylumById(id);
        }else if(classService.isPresent(id)){
            taxon = classService.getClassById(id);
        }else if(orderService.isPresent(id)){
            taxon = orderService.getOrderById(id);
        }else if(familyService.isPresent(id)){
            taxon = familyService.getFamilyById(id);
        }else if(genusService.isPresent(id)){
            taxon = genusService.getGenusById(id);
        }else if(speciesService.isPresent(id)){
            taxon = speciesService.getSpeciesById(id);
        }
        return taxon;
    }

}


