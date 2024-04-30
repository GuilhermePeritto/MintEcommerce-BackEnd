package br.com.mintecommerce.dto.request;

import br.com.mintecommerce.entity.Usuario;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioRequestDTO(
        UUID id,
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento,
        String cpf,
        String telefone,
        String endereco,
        String complemento,
        String cep,
        String cidade,
        String estado,
        String pais
) {
    public Usuario toEntity() {
        return new Usuario(id, nome, email, senha, dataNascimento, cpf, telefone, endereco, complemento, cep, cidade, estado, pais);
    }
}