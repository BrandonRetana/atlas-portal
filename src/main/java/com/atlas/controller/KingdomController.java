package com.atlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atlas.service.KingdomService;
import com.atlas.models.taxonModels.Kingdom;


@RestController
@RequestMapping("/kingdoms")
public class KingdomController {

    @Autowired
    private KingdomService kingdomService;


    //public KingdomController(KingdomService kingdomService) {
    //    this.kingdomService = kingdomService;
    //}

    @RequestMapping("/all")
    public List<Kingdom> getAllKingdoms() {
        return kingdomService.getAllKingdoms();
    }

    @RequestMapping("/{id}")
    public Kingdom getKingdomById(@PathVariable long id) {
        return kingdomService.getKingdomById(id);
    }

    @PostMapping("/")
    public Kingdom createKingdom(@RequestBody Kingdom kingdom) {
        return kingdomService.addKingdom(kingdom);
    }

    @PutMapping("/")
    public Kingdom updateKingdom(@RequestBody Kingdom kingdom) {
        return kingdomService.updateKingdom(kingdom);
    }

    @DeleteMapping("/{id}")
    public void deleteKingdom(@PathVariable long id) {
        kingdomService.deleteKingdom(id);
    }
}


