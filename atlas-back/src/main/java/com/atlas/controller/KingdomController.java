package com.atlas.controller;

import java.util.List;

import com.atlas.repository.KingdomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atlas.service.KingdomService;
import com.atlas.models.taxonModels.Kingdom;


@RestController
@RequestMapping("/kingdoms")
public class KingdomController {

    private final KingdomRepository kingdomRepository;

    public KingdomController(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }


    @Autowired
    private KingdomService kingdomService;


    @RequestMapping("/all")
    public List<Kingdom> getAllKingdoms() {
        return kingdomService.getAllKingdoms();
    }

    @RequestMapping("/{id}")
    public Kingdom getKingdomById(@PathVariable long id) {
        return kingdomService.getKingdomById(id);
    }

    //@PostMapping("/")
    //public Kingdom createKingdom(@RequestBody Kingdom kingdom) {
   //     return kingdomService.addKingdom(kingdom);
  //  }

    @PutMapping("/")
    public Kingdom updateKingdom(@RequestBody Kingdom kingdom) {
        return kingdomService.updateKingdom(kingdom);
    }

    @DeleteMapping("/{id}")
    public void deleteKingdom(@PathVariable long id) {
        kingdomService.deleteKingdom(id);
    }
}


