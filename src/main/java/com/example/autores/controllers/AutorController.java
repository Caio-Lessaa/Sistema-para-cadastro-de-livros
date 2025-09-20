package com.example.autores.controllers;

import com.example.autores.entities.Autor;
import com.example.autores.service.AutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor) {
       return  autorService.cadastrarAutor(autor);
    }
}
