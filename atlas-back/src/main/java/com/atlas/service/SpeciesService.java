package com.atlas.service;

import com.atlas.models.taxonModels.Species;
import com.atlas.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species getSpeciesById(long id) {
        return speciesRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    
    @Transactional
    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    
    @Transactional
    public Species addSpecies(Species species) {
        return speciesRepository.save(species);
    }

    
    @Transactional
    public Species updateSpecies(Species species) {
        return speciesRepository.save(species);
    }
    
    @Transactional
    public void deleteSpecies(long id) {
        speciesRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return speciesRepository.existsById(id);
    }

}


