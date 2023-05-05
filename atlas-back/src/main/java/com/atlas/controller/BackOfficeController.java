package com.atlas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atlas.GeneralInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.atlas.models.taxonModels.Kingdom;
import com.atlas.service.KingdomService;

@Controller
@RequestMapping
public class BackOfficeController implements GeneralInterface {

    @Autowired
    private KingdomService kingdomService;

    @GetMapping("/back/office")
    public @ResponseBody Map<String, Object> getBackOffice(){
        Map<String, Object> response = new HashMap<>();
        List<Kingdom> species = kingdomService.getAllKingdoms();
        response.put("species", species);
        return response;
    }

    @GetMapping("/test")
    public String test(){
        Kingdom k = new Kingdom("prueba", "Eddy", 2003);
        kingdomService.addKingdom(k);

        return "index";
    }

    @Override
    public String obetnerString() {
        return "BackOffice";
    }
}
