package com.example.autores.dto;

import com.example.autores.entities.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroResponseDTO {
    private Long id;
    private String nome;
    private String categoria;
    private Long autorId;

    public LivroResponseDTO(Livro entity) {
        id = entity.getId();
        nome = entity.getNome();
        categoria = entity.getCategoria();
        autorId = entity.getAutor().getId();
    }
}
