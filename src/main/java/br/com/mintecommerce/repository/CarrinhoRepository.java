package br.com.mintecommerce.repository;

import br.com.mintecommerce.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {
}
