package br.com.mintecommerce.service.usuario;

import br.com.mintecommerce.dto.request.UsuarioRequestDTO;
import br.com.mintecommerce.dto.response.UsuarioResponseDTO;
import br.com.mintecommerce.entity.Usuario;
import br.com.mintecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<UsuarioResponseDTO> findById(UUID id) {
        try {
            UsuarioResponseDTO usuarioResponseDTO = usuarioRepository.findById(id).stream().map(UsuarioResponseDTO::new).findFirst().orElse(null);
            if(usuarioResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> findByEmail(String email) {
        try {
            UsuarioResponseDTO usuarioResponseDTO = usuarioRepository.findByEmail(email).stream().map(UsuarioResponseDTO::new).findFirst().orElse(null);
            if(usuarioResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        try {
            List<UsuarioResponseDTO> usuarioResponseDTO = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
            if(usuarioResponseDTO.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity create(UsuarioRequestDTO usuarioDTO) {
        try {
            usuarioRepository.save(usuarioDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity update(UUID id, UsuarioRequestDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioDTO.toEntity();
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> entrar(String email, String senha) {
        try {
            UsuarioResponseDTO usuarioResponseDTO = usuarioRepository.findByEmailAndSenha(email, senha).stream().map(UsuarioResponseDTO::new).findFirst().orElse(null);
            if (usuarioResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
