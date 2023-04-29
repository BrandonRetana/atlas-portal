package com.atlas.service;

import com.atlas.repository.ClassRepository;
import com.atlas.models.taxonModels.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public Class getClassById(long id) {
       Optional<Class> class1 = classRepository.findById(id);
       if (class1.isPresent()) {
           return class1.get();
       } else {
           throw new RuntimeException("Class not found");
       }
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    
    @Transactional
    public Class addClass(Class class1) {
        return classRepository.save(class1);
    }

    
    @Transactional
    public Class updateClass(Class class1) {
        return classRepository.save(class1);
    }

    
    @Transactional
    public void deleteClass(long id) {
        classRepository.deleteById(id);
    }

}



