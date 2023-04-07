package com.atlas.service;

import com.atlas.models.taxonModels.Species;
import com.atlas.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    SpeciesRepository speciesRepository;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species getOrderById(long id) {
        return speciesRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Class getSpeciesByName(String name){ 
        Optional<Species> Species = SpeciesRepository.findByName(name);
           if (Species.isPresent()) {
           return Species.get();
       } else {
           throw new RuntimeException("Species not found");
       }
    }

    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    public Species addSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public void deleteSpecies(long id) {
        speciesRepository.deleteById(id);
    }

}


