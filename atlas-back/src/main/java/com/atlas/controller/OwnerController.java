package com.atlas.controller;

import com.atlas.GeneralInterface;
import com.atlas.models.Owner;
import com.atlas.models.Person;
import com.atlas.service.OwnerService;
import com.atlas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class OwnerController implements GeneralInterface {

    @Autowired
    private OwnerService service;

    @Autowired
    private PersonService personService;

    @GetMapping("/list/owner")
    public @ResponseBody Map<String, Object> getOwners(){
        Map<String, Object> response = new HashMap<>();
        List<Owner> owners = service.getAllOwner();
        response.put("owners", owners);
        return response;
    }

    @GetMapping("/list/person")
    public @ResponseBody Map<String, Object> getPersons(){
        Map<String, Object> response = new HashMap<>();
        List<Person> persons = personService.getAllPersons();
        response.put("persons", persons);
        return response;
    }

    @Override
    public String obetnerString() {
        return "Owner";
    }


}
