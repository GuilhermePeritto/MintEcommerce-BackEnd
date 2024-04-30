package br.com.mintecommerce.service.categoria;

import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ICategoriaService {
    ResponseEntity<CategoriaResponseDTO> findById(UUID id);

    ResponseEntity<List<CategoriaResponseDTO>> findAll();

    ResponseEntity create(CategoriaRequestDTO categoriaRequestDTO);

    ResponseEntity update(UUID id, CategoriaRequestDTO categoriaRequestDTO);

    ResponseEntity delete(UUID id);
}
