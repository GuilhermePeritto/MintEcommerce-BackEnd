package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.entity.Imagem;

import java.util.UUID;

public record ImagemRequestDTO(
        UUID id,
        byte[] imagem
) {
    public Imagem toEntity() {
        return new Imagem(id, imagem);
    }
}
