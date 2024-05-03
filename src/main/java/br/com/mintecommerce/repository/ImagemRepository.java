package br.com.mintecommerce.repository;

import br.com.mintecommerce.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagemRepository extends JpaRepository<Imagem, UUID> {
}
