package com.atlas.controller;

import com.atlas.models.taxonModels.Kingdom;
import com.atlas.service.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private KingdomService kingdomService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/ktest")
    public void createKingdomTest() {
        System.out.println("Hola");
        Kingdom k = new Kingdom();
        k.setAuthor("sdf");
        k.setPublicationYear(100);
        k.setScientificName("EDditus");
        kingdomService.addKingdom(k);
    }
}
