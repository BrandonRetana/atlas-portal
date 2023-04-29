package com.atlas.service;

import com.atlas.repository.GenusRepository;
import com.atlas.models.taxonModels.Genus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenusService {
    @Autowired
    GenusRepository genusRepository;

    public Genus getGenusById(long id) {
       Optional<Genus> genus = genusRepository.findById(id);
       if (genus.isPresent()) {
           return genus.get();
       } else {
           throw new RuntimeException("Genus not found");
       }
    }

    public List<Genus> getAllGenus() {
        return genusRepository.findAll();
    }

    
    @Transactional
    public Genus addGenus(Genus genus) {
        return genusRepository.save(genus);
    }

    
    @Transactional
    public Genus updateGenus(Genus genus) {
        return genusRepository.save(genus);
    }

    
    @Transactional
    public void deleteGenus(long id) {
        genusRepository.deleteById(id);
    }

}

   