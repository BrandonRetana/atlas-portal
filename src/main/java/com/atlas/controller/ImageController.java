package com.atlas.controller;


import java.io.File;
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

    @PostMapping("/upload")
public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    System.out.println("Nombre del archivo recibido: " + file.getOriginalFilename());

    try {
        // Obtiene la ruta absoluta de la carpeta "static"
        String rootPath = System.getProperty("user.dir");
        String staticPath = rootPath + "/src/main/resources/static/";

        // Crea el archivo en la carpeta "static/img"
        File dir = new File(staticPath + "img/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Path path = Paths.get(staticPath + "img/" + file.getOriginalFilename());
        Files.write(path, file.getBytes());
        System.out.println("Ruta absoluta de la carpeta static: " + staticPath);


        return new ResponseEntity<>("Archivo cargado correctamente", HttpStatus.OK);

    } catch (IOException e) {
        e.printStackTrace();
        return new ResponseEntity<>("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    

}
