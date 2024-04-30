package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.entity.Categoria;

import java.util.UUID;

public record CategoriaRequestDTO(
        UUID id,
        String nome
) {
    public Categoria toEntity() {
        return new Categoria(id, nome);
    }
}
