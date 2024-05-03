package br.com.mintecommerce.service.pedido;

import br.com.mintecommerce.dto.request.PedidoRequestDTO;
import br.com.mintecommerce.dto.response.PedidoResponseDTO;
import br.com.mintecommerce.entity.Pedido;
import br.com.mintecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override

    public ResponseEntity<PedidoResponseDTO> findById(UUID id) {
        try {
            PedidoResponseDTO pedidoResponseDTO = pedidoRepository.findById(id).stream().map(PedidoResponseDTO::new).findFirst().orElse(null);
            if(pedidoResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(pedidoResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<PedidoResponseDTO>> findAll() {
        try {
            List<PedidoResponseDTO> pedidoResponseDTOList = pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
            return ResponseEntity.ok(pedidoResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity create(PedidoRequestDTO pedidoRequestDTO) {
        try {
            pedidoRepository.save(pedidoRequestDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(UUID id, PedidoRequestDTO pedidoRequestDTO) {
        try {
            Pedido pedido = pedidoRequestDTO.toEntity();
            pedido.setId(id);
            pedidoRepository.save(pedido);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
