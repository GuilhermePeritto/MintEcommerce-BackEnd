package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.request.ImagemRequestDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import br.com.mintecommerce.dto.response.ImagemResponseDTO;
import br.com.mintecommerce.service.categoria.CategoriaService;
import br.com.mintecommerce.service.imagem.ImagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("imagem")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ImagemController {

    private final ImagemService imagemService;

    @GetMapping("/listar")
    public ResponseEntity<List<ImagemResponseDTO>> getAll() {
        return imagemService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ImagemResponseDTO> getById(@PathVariable UUID id) {
        return imagemService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody ImagemRequestDTO imagemRequestDTO) {
        return imagemService.create(imagemRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody ImagemRequestDTO imagemRequestDTO) {
        return imagemService.update(id, imagemRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return imagemService.delete(id);
    }
}
