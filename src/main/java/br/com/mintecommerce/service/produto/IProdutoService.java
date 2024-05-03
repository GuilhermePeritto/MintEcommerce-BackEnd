package br.com.mintecommerce.service.produto;

import br.com.mintecommerce.dto.request.ProdutoRequestDTO;
import br.com.mintecommerce.dto.response.ProdutoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IProdutoService {
    ResponseEntity<ProdutoResponseDTO> findById(UUID id);

    ResponseEntity<List<ProdutoResponseDTO>> findAll();

    ResponseEntity create(ProdutoRequestDTO categoriaRequestDTO);

    ResponseEntity update(UUID id, ProdutoRequestDTO categoriaRequestDTO);

    ResponseEntity delete(UUID id);
}
