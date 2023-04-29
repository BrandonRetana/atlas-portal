package com.atlas.service;

import com.atlas.repository.FamilyRepository;
import com.atlas.models.taxonModels.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    private FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Family getFamilyById(long id) {
       Optional<Family> family = familyRepository.findById(id);
       if (family.isPresent()) {
           return family.get();
       } else {
           throw new RuntimeException("Family not found");
       }
    }

    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    
    @Transactional
    public Family addFamily(Family family) {
        return familyRepository.save(family);
    }

    
    @Transactional
    public Family updateFamily(Family family) {
        return familyRepository.save(family);
    }

    
    @Transactional
    public void deleteFamily(long id) {
        familyRepository.deleteById(id);
    }
    


}
