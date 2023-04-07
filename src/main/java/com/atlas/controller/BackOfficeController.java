package com.atlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atlas.models.taxonModels.Kingdom;
import com.atlas.service.KingdomService;

@Controller
@RequestMapping
public class BackOfficeController {

    @Autowired
    private KingdomService kingdomService;

    @GetMapping("/back/office")
    public ModelAndView getBackOffice(){
        List<Kingdom> species = kingdomService.getAllKingdoms();
        ModelAndView mav = new ModelAndView("backOffice");
        mav.addObject("species", species);
        return mav;
    }

    @GetMapping("/test")
    public String test(){
        Kingdom k = new Kingdom("prueba", "Eddy", 2003);
        kingdomService.addKingdom(k);

        return "index";
    }
}
