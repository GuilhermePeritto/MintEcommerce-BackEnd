package br.com.mintecommerce.service.pedido;

import br.com.mintecommerce.dto.request.PedidoRequestDTO;
import br.com.mintecommerce.dto.response.PedidoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IPedidoService {
    ResponseEntity<PedidoResponseDTO> findById(UUID id);

    ResponseEntity<List<PedidoResponseDTO>> findAll();

    ResponseEntity create(PedidoRequestDTO pedidoRequestDTO);

    ResponseEntity update(UUID id, PedidoRequestDTO pedidoRequestDTO);

    ResponseEntity delete(UUID id);
}
