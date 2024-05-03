package br.com.mintecommerce.service.imagem;

import br.com.mintecommerce.dto.request.ImagemRequestDTO;
import br.com.mintecommerce.dto.response.ImagemResponseDTO;
import br.com.mintecommerce.entity.Imagem;
import br.com.mintecommerce.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImagemService implements IImagemService{

    @Autowired
    private ImagemRepository imagemRepository;

    @Override

    public ResponseEntity<ImagemResponseDTO> findById(UUID id) {
        try {
            ImagemResponseDTO imagemResponseDTO = imagemRepository.findById(id).stream().map(ImagemResponseDTO::new).findFirst().orElse(null);
            if(imagemResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imagemResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<ImagemResponseDTO>> findAll() {
        try {
            List<ImagemResponseDTO> imagemResponseDTOList = imagemRepository.findAll().stream().map(ImagemResponseDTO::new).toList();
            return ResponseEntity.ok(imagemResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
        public ResponseEntity create(ImagemRequestDTO imagemRequestDTO) {
        try {
            imagemRepository.save(imagemRequestDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(UUID id, ImagemRequestDTO imagemRequestDTO) {
        try {
            Imagem imagem = imagemRequestDTO.toEntity();
            imagem.setId(id);
            imagemRepository.save(imagem);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            imagemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}