package com.atlas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class TaxonController {
    
    @GetMapping("/create/taxon")
    public String createTaxon(){
        return "formImage";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    // Guarda el archivo en el servidor o haz algo más con él
    return new ResponseEntity<>("Archivo cargado correctamente", HttpStatus.OK);
}

}
