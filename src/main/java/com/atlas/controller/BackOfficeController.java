package com.atlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BackOfficeController {
  
    @GetMapping("/back/office")
    public String getBackOffice(){
        return "backOffice";
    }
}
