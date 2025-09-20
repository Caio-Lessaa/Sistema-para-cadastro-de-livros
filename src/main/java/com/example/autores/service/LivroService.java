package com.example.autores.service;

import com.example.autores.dto.LivroRequestDTO;
import com.example.autores.dto.LivroResponseDTO;
import com.example.autores.entities.Autor;
import com.example.autores.entities.Livro;
import com.example.autores.repositoy.AutorRepository;
import com.example.autores.repositoy.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO dto) {
        Livro entity = new Livro();
        entity.setNome(dto.getNome());
        entity.setCategoria(dto.getCategoria());
        Autor autor = autorRepository.findById(dto.getAutorId()).orElseThrow(() -> new RuntimeException("Autor não encontrado para o ID informado"));

        entity.setAutor(autor);

        entity = livroRepository.save(entity);
        return new LivroResponseDTO(entity);
    }

    public List<LivroResponseDTO> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroResponseDTO> livroResponseDTOS = new ArrayList<>();

        for(Livro entity : livros) {
            LivroResponseDTO dto = new LivroResponseDTO(entity);
            livroResponseDTOS.add(dto);
        }

        return livroResponseDTOS;
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
