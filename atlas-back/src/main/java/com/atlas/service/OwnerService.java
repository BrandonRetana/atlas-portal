package com.atlas.service;

import com.atlas.GeneralInterface;
import com.atlas.models.Owner;
import com.atlas.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements GeneralInterface {
    @Autowired
    private OwnerRepository respository;

    public List<Owner> getAllOwner() {
        return respository.findAll();
    }

    @Override
    public String obetnerString() {
        return "Owner";
    }



}
