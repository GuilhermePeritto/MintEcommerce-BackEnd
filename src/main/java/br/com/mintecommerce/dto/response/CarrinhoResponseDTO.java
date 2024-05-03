package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.entity.Carrinho;
import br.com.mintecommerce.entity.Produto;
import br.com.mintecommerce.entity.Usuario;

import java.util.List;
import java.util.UUID;

public record CarrinhoResponseDTO(
        UUID id,
        Float valorTotal,
        Usuario usuario,
        UUID idPedido,
        List<Produto> produtos
) {
    public CarrinhoResponseDTO(Carrinho carrinho) {
        this(carrinho.getId(), carrinho.getValorTotal(), carrinho.getUsuario(), carrinho.getIdPedido(), carrinho.getProdutos());
    }
}
