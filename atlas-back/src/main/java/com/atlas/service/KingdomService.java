package com.atlas.service;

import com.atlas.repository.KingdomRepository;
import com.atlas.models.taxonModels.Kingdom;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KingdomService {

    @Autowired
    private KingdomRepository kingdomRepository;

    @Transactional
    public void addKingdom(Kingdom kingdom) {
        kingdomRepository.save(kingdom);
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

    
    @Transactional
    public Kingdom updateKingdom(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }

    
    @Transactional
    public void deleteKingdom(long id) {
        kingdomRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return kingdomRepository.existsById(id);
    }
 
}