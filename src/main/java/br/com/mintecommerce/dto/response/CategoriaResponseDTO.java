package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.entity.Categoria;

import java.util.UUID;

public record CategoriaResponseDTO(
        UUID id,
        String nome
) {
    public CategoriaResponseDTO(Categoria categoria){
        this(categoria.getId(), categoria.getNome());
    }
}
