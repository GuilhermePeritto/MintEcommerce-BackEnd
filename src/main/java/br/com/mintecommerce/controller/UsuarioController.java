package br.com.mintecommerce.controller;

import br.com.mintecommerce.dto.request.UsuarioRequestDTO;
import br.com.mintecommerce.dto.response.UsuarioResponseDTO;
import br.com.mintecommerce.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("usuario")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/entrar")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.login(usuarioRequestDTO.email(), usuarioRequestDTO.senha());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity create(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.create(usuarioRequestDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.update(id, usuarioRequestDTO);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return usuarioService.delete(id);
    }
}
