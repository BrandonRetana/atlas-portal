package com.atlas.service;

import com.atlas.repository.GenusRepository;
import com.atlas.models.taxonModels.Genus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenusService {

    GenusRepository genusRepository;

    @Autowired
    public GenusService(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    public Genus getGenusById(long id) {
       Optional<Genus> genus = genusRepository.findById(id);
       if (genus.isPresent()) {
           return genus.get();
       } else {
           throw new RuntimeException("Genus not found");
       }
    }

    public List<Genus> getAllGenera() {
        return genusRepository.findAll();
    }

    public Genus addGenus(Genus genus) {
        return genusRepository.save(genus);
    }

    public Genus updateGenus(Genus genus) {
        return genusRepository.save(genus);
    }

    public void deleteGenus(long id) {
        genusRepository.deleteById(id);
    }

}

   