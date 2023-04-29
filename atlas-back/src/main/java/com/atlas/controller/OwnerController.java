package com.atlas.controller;

import com.atlas.models.Owner;
import com.atlas.service.OwnerService;
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
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping("/list/author")
    public @ResponseBody Map<String, Object> getOwners(){
        Map<String, Object> response = new HashMap<>();
        List<Owner> owners = service.getAllOwner();
        response.put("authors", owners);
        return response;
    }


}
