package br.com.mintecommerce.service.categoria;

import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import br.com.mintecommerce.entity.Categoria;
import br.com.mintecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override

    public ResponseEntity<CategoriaResponseDTO> findById(UUID id) {
        try {
            CategoriaResponseDTO categoriaResponseDTO = categoriaRepository.findById(id).stream().map(CategoriaResponseDTO::new).findFirst().orElse(null);
            if(categoriaResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(categoriaResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        try {
            List<CategoriaResponseDTO> categoriaResponseDTOList = categoriaRepository.findAll().stream().map(CategoriaResponseDTO::new).toList();
            return ResponseEntity.ok(categoriaResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity create(CategoriaRequestDTO categoriaRequestDTO) {
        try {
            categoriaRepository.save(categoriaRequestDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(UUID id, CategoriaRequestDTO categoriaRequestDTO) {
        try {
            Categoria categoria = categoriaRequestDTO.toEntity();
            categoria.setId(id);
            categoriaRepository.save(categoria);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
