package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.Enum.EnumStatusPedido;
import br.com.mintecommerce.entity.Pedido;
import br.com.mintecommerce.entity.Produto;
import br.com.mintecommerce.entity.Usuario;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PedidoRequestDTO(
        UUID id,
        Date dataPedido,
        EnumStatusPedido enumStatusPedido,
        Float valorTotal,
        Usuario usuario,
        List<Produto> produtos
) {
    public Pedido toEntity() {
        return new Pedido(id, dataPedido, enumStatusPedido, valorTotal, usuario, produtos);
    }
}
