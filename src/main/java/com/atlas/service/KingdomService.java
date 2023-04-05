package com.atlas.service;

import com.atlas.repository.KingdomRepository;
import com.atlas.models.taxonModels.Kingdom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KingdomService {

    private KingdomRepository kingdomRepository;


    @Autowired
    public KingdomService(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }

    public Kingdom getKingdomById(long id) {
       Optional<Kingdom> kingdom = kingdomRepository.findById(id);
       if (kingdom.isPresent()) {
           return kingdom.get();
       } else {
           throw new RuntimeException("Kingdom not found");
       }
    }

    public List<Kingdom> getAllKingdoms() {
        return kingdomRepository.findAll();
    } 

    public Kingdom addKingdom(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }
    public Kingdom updateKingdom(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }

    public void deleteKingdom(long id) {
        kingdomRepository.deleteById(id);
    }
 
}