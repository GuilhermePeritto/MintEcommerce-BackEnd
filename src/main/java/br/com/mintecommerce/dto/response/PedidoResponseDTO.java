package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.Enum.EnumStatusPedido;
import br.com.mintecommerce.entity.Pedido;
import br.com.mintecommerce.entity.Produto;
import br.com.mintecommerce.entity.Usuario;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PedidoResponseDTO(
        UUID id,
        Date dataPedido,
        EnumStatusPedido enumStatusPedido,
        Float valorTotal,
        Usuario usuario,
        List<Produto> produtos
) {
    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getDataPedido(), pedido.getEnumStatusPedido(), pedido.getValorTotal(), pedido.getUsuario(), pedido.getProduto());
    }
}
