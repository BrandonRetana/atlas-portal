package com.atlas.controller;

import com.atlas.models.Image;
import com.atlas.models.Owner;
import com.atlas.models.taxonModels.Kingdom;
import com.atlas.service.ImageService;
import com.atlas.service.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/list/image")
    public @ResponseBody Map<String, Object> getOwners(){
        Map<String, Object> response = new HashMap<>();
        List<Image> images = imageService.getAllImages();
        response.put("images", images);
        return response;
    }


}
