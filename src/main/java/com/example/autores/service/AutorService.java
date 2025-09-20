package com.example.autores.service;

import com.example.autores.entities.Autor;
import com.example.autores.repositoy.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor cadastrarAutor(Autor autor){
        autor = autorRepository.save(autor);
        return autor;
    }
}
