package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.entity.Imagem;

import java.util.UUID;

public record ImagemResponseDTO(
        UUID id,
        byte[] imagem
) {
    public ImagemResponseDTO(Imagem imagem) {
        this(imagem.getId(), imagem.getImagem());
    }
}
