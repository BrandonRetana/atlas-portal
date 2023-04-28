package com.atlas.controller;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atlas.models.TaxonFactory;
import com.atlas.models.taxonModels.Kingdom;
import com.atlas.service.KingdomService;

@Controller
@RequestMapping
public class TaxonController {
    @Autowired
    private KingdomService ks;
    private TaxonFactory taxonFactory = new TaxonFactory();


    @PostMapping("/create/taxon")
    public @ResponseBody Map<String, String> getTaxon(@RequestBody Map<String, Object> data,   RedirectAttributes redirectAttributes){
        Map<String, String> response = new HashMap<>();
        try {
           
            System.out.println("entra");
            taxonFactory.createTaxon(data);
            System.out.println("Sale");
            response.put("SI", "se creo");
            return ResponseEntity.ok(response).getBody();

        } catch (Exception e) {
            response.put("NO", "Se creo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response).getBody();
        }
    }

    @GetMapping("/random")
    public void random(){
        System.out.println("entraaaaa11111");
        Kingdom k = new Kingdom("prueba", "Eddy", 2003);
        ks.addKingdom(k);
        System.out.println("entraaaaa");

    }    

}
