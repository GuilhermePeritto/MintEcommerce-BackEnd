package br.com.mintecommerce.service.carrinho;

import br.com.mintecommerce.dto.request.CarrinhoRequestDTO;
import br.com.mintecommerce.dto.response.CarrinhoResponseDTO;
import br.com.mintecommerce.entity.Carrinho;
import br.com.mintecommerce.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarrinhoService implements ICarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override

    public ResponseEntity<CarrinhoResponseDTO> findById(UUID id) {
        try {
            CarrinhoResponseDTO carrinhoResponseDTO = carrinhoRepository.findById(id).stream().map(CarrinhoResponseDTO::new).findFirst().orElse(null);
            if(carrinhoResponseDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(carrinhoResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<CarrinhoResponseDTO>> findAll() {
        try {
            List<CarrinhoResponseDTO> carrinhoResponseDTOList = carrinhoRepository.findAll().stream().map(CarrinhoResponseDTO::new).toList();
            return ResponseEntity.ok(carrinhoResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity create(CarrinhoRequestDTO carrinhoRequestDTO) {
        try {
            carrinhoRepository.save(carrinhoRequestDTO.toEntity());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(UUID id, CarrinhoRequestDTO carrinhoRequestDTO) {
        try {
            Carrinho carrinho = carrinhoRequestDTO.toEntity();
            carrinho.setId(id);
            carrinhoRepository.save(carrinho);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity delete(UUID id) {
        try {
            carrinhoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
