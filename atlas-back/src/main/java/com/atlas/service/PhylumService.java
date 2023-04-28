package com.atlas.service;

import com.atlas.repository.PhylumRepository;
import com.atlas.models.taxonModels.Phylum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhylumService{

    PhylumRepository phylumRepository;

    @Autowired
    public PhylumService(PhylumRepository phylumRepository) {
        this.phylumRepository = phylumRepository;
    }

    public Phylum getPhylumById(long id) {
        return phylumRepository.findById(id).orElseThrow(() -> new RuntimeException("Phylum not found"));
    }

    public List<Phylum> getAllPhyla() {
        return phylumRepository.findAll();
    }

    public Phylum addPhylum(Phylum phylum) {
        System.out.println("entra al service");
        return phylumRepository.save(phylum);
    }

    public Phylum updatePhylum(Phylum phylum) {
        return phylumRepository.save(phylum);
    }

    public void deletePhylum(long id) {
        phylumRepository.deleteById(id);
    }

}
