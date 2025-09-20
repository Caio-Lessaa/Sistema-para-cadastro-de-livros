package com.example.autores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LivroRequestDTO {
    private String nome;
    private String categoria;
    private Long autorId;
}
