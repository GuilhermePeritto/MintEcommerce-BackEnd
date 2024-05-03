package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.CarrinhoRequestDTO;
import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.response.CarrinhoResponseDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import br.com.mintecommerce.service.carrinho.CarrinhoService;
import br.com.mintecommerce.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("carrinho")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @GetMapping("/listar")
    public ResponseEntity<List<CarrinhoResponseDTO>> getAll() {
        return carrinhoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<CarrinhoResponseDTO> getById(@PathVariable UUID id) {
        return carrinhoService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody CarrinhoRequestDTO carrinhoRequestDTO) {
        return carrinhoService.create(carrinhoRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CarrinhoRequestDTO carrinhoRequestDTO) {
        return carrinhoService.update(id, carrinhoRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return carrinhoService.delete(id);
    }
}
