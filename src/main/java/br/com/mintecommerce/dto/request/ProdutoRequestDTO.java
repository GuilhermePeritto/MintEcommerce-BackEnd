package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.entity.Categoria;
import br.com.mintecommerce.entity.Produto;

import java.util.UUID;

public record ProdutoRequestDTO(
        UUID id,
        String nome,
        String descricao,
        Float preco,
        Integer quantidade,
        Integer quantidadeestoque,
        Categoria categoria
) {
    public Produto toEntity() {
        return new Produto(id, nome, descricao, preco, quantidade, quantidadeestoque, categoria);
    }
}
