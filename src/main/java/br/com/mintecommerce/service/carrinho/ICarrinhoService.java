package br.com.mintecommerce.service.carrinho;

import br.com.mintecommerce.dto.request.CarrinhoRequestDTO;
import br.com.mintecommerce.dto.response.CarrinhoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ICarrinhoService {
    ResponseEntity<CarrinhoResponseDTO> findById(UUID id);

    ResponseEntity<List<CarrinhoResponseDTO>> findAll();

    ResponseEntity create(CarrinhoRequestDTO carrinhoRequestDTO);

    ResponseEntity update(UUID id, CarrinhoRequestDTO carrinhoRequestDTO);

    ResponseEntity delete(UUID id);
}
