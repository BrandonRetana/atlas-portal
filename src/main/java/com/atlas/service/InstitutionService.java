package com.atlas.service;

import com.atlas.repository.InstitutionRepository;
import com.atlas.models.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Institution getInstitutionById(long id) {
        Optional<Institution> institution = institutionRepository.findById(id);
        if (institution.isPresent()) {
            return institution.get();
        } else {
            throw new RuntimeException("Institution not found");
        }
    }

    public Class getInstitutionByName(String name){ 
        Optional<Institution> institution = institutionRepository.findByName(name);
           if (institution.isPresent()) {
           return institution.get();
       } else {
           throw new RuntimeException("Institution not found");
       }
    }

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution addInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    public Institution updateInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    public void deleteInstitution(long id) {
        institutionRepository.deleteById(id);
    }

}
  