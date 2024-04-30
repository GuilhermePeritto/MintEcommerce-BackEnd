package br.com.mintecommerce.service.produto;

import br.com.mintecommerce.dto.request.ProdutoRequestDTO;
import br.com.mintecommerce.dto.response.ProdutoResponseDTO;
import br.com.mintecommerce.entity.Produto;
import br.com.mintecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProdutoService implements IProdutoService{

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public ResponseEntity<ProdutoResponseDTO> findById(UUID id) {
        try {
            ProdutoResponseDTO produtoResponseDTO = produtoRepository.findById(id).stream().map(ProdutoResponseDTO::new).findFirst().orElse(null);
            if(produtoResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(produtoResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        try {
            List<ProdutoResponseDTO> produtoResponseDTOList = produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
            return ResponseEntity.ok(produtoResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity create(ProdutoRequestDTO categoriaRequestDTO) {
        try {
            produtoRepository.save(categoriaRequestDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(UUID id, ProdutoRequestDTO categoriaRequestDTO) {
        try {
            Produto produto = categoriaRequestDTO.toEntity();
            produto.setId(id);
            produtoRepository.save(produto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
