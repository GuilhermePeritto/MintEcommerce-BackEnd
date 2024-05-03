package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.PedidoRequestDTO;
import br.com.mintecommerce.dto.response.PedidoResponseDTO;
import br.com.mintecommerce.service.pedido.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pedido")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/listar")
    public ResponseEntity<List<PedidoResponseDTO>> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PedidoResponseDTO> getById(@PathVariable UUID id) {
        return pedidoService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.create(pedidoRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.update(id, pedidoRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return pedidoService.delete(id);
    }
}
