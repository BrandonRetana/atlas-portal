package com.atlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/page/tucan")
    public String singlePage(){
        return "page";
    }
    
}
