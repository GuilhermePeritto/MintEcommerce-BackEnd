package br.com.mintecommerce.service.usuario;

import br.com.mintecommerce.dto.request.UsuarioRequestDTO;
import br.com.mintecommerce.dto.response.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IUsuarioService {
    ResponseEntity<UsuarioResponseDTO> findById(UUID id);

    ResponseEntity<UsuarioResponseDTO> findByEmail(String email);

    ResponseEntity<List<UsuarioResponseDTO>> findAll();

    ResponseEntity create(UsuarioRequestDTO usuarioDTO);

    ResponseEntity update(UUID id, UsuarioRequestDTO usuarioDTO);

    ResponseEntity delete(UUID id);

    ResponseEntity<UsuarioResponseDTO> entrar(String email, String senha);
}
