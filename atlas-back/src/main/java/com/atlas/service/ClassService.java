package com.atlas.service;

import com.atlas.repository.ClassRepository;
import com.atlas.models.taxonModels.TClass;
import org.springframework.beans.factory.annotation.Autowired;
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

    public TClass getClassById(long id) {
       Optional<TClass> class1 = classRepository.findById(id);
       if (class1.isPresent()) {
           return class1.get();
       } else {
           throw new RuntimeException("Class not found");
       }
    }

    public List<TClass> getAllClasses() {
        return classRepository.findAll();
    }

    public TClass addClass(TClass class1) {
        return classRepository.save(class1);
    }

    public TClass updateClass(TClass class1) {
        return classRepository.save(class1);
    }

    public void deleteClass(long id) {
        classRepository.deleteById(id);
    }

}



