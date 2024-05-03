package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.entity.Carrinho;
import br.com.mintecommerce.entity.Produto;
import br.com.mintecommerce.entity.Usuario;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public record CarrinhoRequestDTO(
        UUID id,
        Float valorTotal,
        Usuario usuario,
        UUID idPedido,
        List<Produto>produtos
) {
    public Carrinho toEntity() {
        return new Carrinho(id, valorTotal, usuario, idPedido, produtos);
    }
}
