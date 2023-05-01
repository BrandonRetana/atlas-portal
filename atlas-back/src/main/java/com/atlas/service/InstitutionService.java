package com.atlas.service;

import com.atlas.models.Institution;
import com.atlas.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution getInstitutionById(long id) {
        return institutionRepository.findById(id).get();
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

    public boolean isPresent(long id) {
        return institutionRepository.existsById(id);
    }
}
