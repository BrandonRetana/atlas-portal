package com.atlas.service;

import com.atlas.repository.PhylumRepository;
import com.atlas.models.taxonModels.Phylum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    
    @Transactional
    public List<Phylum> getAllPhylums() {
        return phylumRepository.findAll();
    }

    
    @Transactional
    public Phylum addPhylum(Phylum phylum) {
        return phylumRepository.save(phylum);
    }

    
    @Transactional
    public Phylum updatePhylum(Phylum phylum) {
        return phylumRepository.save(phylum);
    }

    
    @Transactional
    public void deletePhylum(long id) {
        phylumRepository.deleteById(id);
    }

}
