package br.com.mintecommerce.service.imagem;

import br.com.mintecommerce.dto.request.CategoriaRequestDTO;
import br.com.mintecommerce.dto.request.ImagemRequestDTO;
import br.com.mintecommerce.dto.response.CategoriaResponseDTO;
import br.com.mintecommerce.dto.response.ImagemResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IImagemService {
    ResponseEntity<ImagemResponseDTO> findById(UUID id);

    ResponseEntity<List<ImagemResponseDTO>> findAll();

    ResponseEntity create(ImagemRequestDTO imagemRequestDTO);

    ResponseEntity update(UUID id, ImagemRequestDTO imagemRequestDTO);

    ResponseEntity delete(UUID id);
}
