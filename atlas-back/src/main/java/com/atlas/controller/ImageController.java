package com.atlas.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
public class ImageController {
    
    @GetMapping("/create/image")
    public String createTaxon(){
        return "formImage";
    }


    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {
        try {
            System.out.println("LLego");
            Path path = Paths.get("/home/brandon/Git/atlas-portal/atlas-front/src/assets/" + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            return ResponseEntity.ok("Archivo cargado con éxito");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar el archivo");
        }
    }






}
