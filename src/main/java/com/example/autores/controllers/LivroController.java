package com.example.autores.controllers;

import com.example.autores.dto.LivroRequestDTO;
import com.example.autores.dto.LivroResponseDTO;
import com.example.autores.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public LivroResponseDTO cadastroLivro(@RequestBody LivroRequestDTO dto) {
       return livroService.cadastrarLivro(dto);
    }

    @GetMapping
    public List<LivroResponseDTO> listarLivros() {
        return livroService.listarLivros();
    }
}
