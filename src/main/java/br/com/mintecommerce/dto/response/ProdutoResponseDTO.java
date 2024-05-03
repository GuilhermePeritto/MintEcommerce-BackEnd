package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.entity.Categoria;
import br.com.mintecommerce.entity.Produto;

import java.util.UUID;

public record ProdutoResponseDTO(
        UUID id,
        String nome,
        String descricao,
        Float preco,
        Integer quantidade,
        Integer quantidadeestoque,
        Categoria categoria
) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(),produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getQuantidadeestoque(), produto.getCategoria());
    }
}
