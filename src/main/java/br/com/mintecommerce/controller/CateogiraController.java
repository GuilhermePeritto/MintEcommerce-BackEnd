package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import br.com.mintecommerce.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("categoria")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CateogiraController {

    private final CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaResponseDTO>> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<CategoriaResponseDTO> getById(@PathVariable UUID id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return categoriaService.create(categoriaRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return categoriaService.update(id, categoriaRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return categoriaService.delete(id);
    }
}
