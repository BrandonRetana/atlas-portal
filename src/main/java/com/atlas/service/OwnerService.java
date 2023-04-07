package com.atlas.service;

import com.atlas.repository.OwnerRepository;
import com.atlas.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public Owner getOwnerById(long id){
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
       } else {
            throw new RuntimeException("Owner not found");
       }
    }

        public Class getOwnerByName(String name){ 
        Optional<Owner> owner = ownerRepository.findByName(name);
           if (owner.isPresent()) {
           return owner.get();
       } else {
           throw new RuntimeException("Owner not found");
       }
    }




    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner addOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public void deleteOwner(long id){
        ownerRepository.deleteById(id);
    }


}



  

   