package com.atlas.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atlas.models.*;
import com.atlas.models.taxonModels.Taxon;
import com.atlas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@Controller
@RequestMapping
public class ImageController {
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
    @Autowired
    private ImageService imageService;
    @Autowired
    private PersonService personService;
    @Autowired
    private InstitutionService institutionService;

    @GetMapping("/create/image")
    public String createTaxon(){
        return "formImage";
    }


    @PostMapping("/upload/image")
    public ResponseEntity<String> submitImage(@RequestParam("image") MultipartFile file,
                                              @RequestParam("imageName") String imageName,
                                              @RequestParam("imageDescription") String imageDescription,
                                              @RequestParam("date") String date,
                                              @RequestParam("author") String author,
                                              @RequestParam("owner") String owner,
                                              @RequestParam("license") String license,
                                              @RequestParam("checkbox1") String checkbox1,
                                              @RequestParam("checkbox2") String checkbox2,
                                              @RequestParam("kingdom") String kingdom,
                                              @RequestParam("phylum") String phylum,
                                              @RequestParam("class") String clazz,
                                              @RequestParam("order") String order,
                                              @RequestParam("family") String family,
                                              @RequestParam("genus") String genus,
                                              @RequestParam("species") String species) {
        Image image = new Image();
        image.setPath("../../assets/" + file.getOriginalFilename());
        image.setDescription(imageDescription);
        image.setCreationDate(date);
        image.setName(imageName);

        String getLicense = License.getTextFromNumero(license);
        image.setLicense(getLicense);
        List<String> keywords = new ArrayList<>();
        keywords.add(checkbox1);
        keywords.add(checkbox2);
        image.setKeywords(keywords);

        Person person = personService.getPersonById(Long.parseLong(author));
        image.setAuthor(person);

        Owner owner1 = getOwnerbyId(Long.parseLong(owner));
        image.setOwner(owner1);

        Taxon species1 = getTaxonbyId(Long.parseLong(species));
        Taxon genus1 = getTaxonbyId(Long.parseLong(genus));
        Taxon family1 = getTaxonbyId(Long.parseLong(family));
        Taxon order1 = getTaxonbyId(Long.parseLong(order));
        Taxon class1 = getTaxonbyId(Long.parseLong(clazz));
        Taxon phylum1 = getTaxonbyId(Long.parseLong(phylum));
        Taxon kingdom1 = getTaxonbyId(Long.parseLong(kingdom));
        image.setTaxon(List.of(species1, genus1, family1, order1, class1, phylum1, kingdom1));
        imageService.addImage(image);

        try {
            System.out.println("LLego");
            Path path = Paths.get("/home/brandon/Git/atlas-portal/atlas-front/src/assets/" + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            return ResponseEntity.ok("Archivo cargado con éxito");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar el archivo");
        }
    }

    @GetMapping("/image/{id}")
    public @ResponseBody Map<String, Object> getImageByID(@PathVariable("id") long id) {
        Map<String, Object> map = new HashMap<>();
        Image image = imageService.getImageById(id);
        map.put("image", image);
        return map;
    }

    @DeleteMapping("/delete/image/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") long id) {
        System.out.println("LLego");
        imageService.deleteImage(id);
        return ResponseEntity.ok("Imagen eliminada con éxito");
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

    public Owner getOwnerbyId(@PathVariable("id") long id) {
        Owner owner = null;
        if(personService.isPresent(id)){
            owner = personService.getPersonById(id);
        }else if(institutionService.isPresent(id)){
            owner = institutionService.getInstitutionById(id);
        }
        return owner;
    }


    @GetMapping("/list/image")
    public @ResponseBody Map<String, Object> getOwners(){
        Map<String, Object> response = new HashMap<>();
        List<Image> images = imageService.getAllImages();
        response.put("images", images);
        return response;
    }



}
