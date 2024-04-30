package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.ProdutoRequestDTO;
import br.com.mintecommerce.dto.response.ProdutoResponseDTO;
import br.com.mintecommerce.service.produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produto")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponseDTO>> getAll() {
        return produtoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoResponseDTO> getById(@PathVariable UUID id) {
        return produtoService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return produtoService.create(produtoRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return produtoService.update(id, produtoRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return produtoService.delete(id);
    }
}
