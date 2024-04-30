package br.com.mintecommerce.dto.response;

import br.com.mintecommerce.entity.Usuario;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioResponseDTO(
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
        public UsuarioResponseDTO(Usuario usuario){
            this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getDataNascimento(), usuario.getCpf(), usuario.getTelefone(), usuario.getEndereco(), usuario.getComplemento(), usuario.getCep(), usuario.getCidade(), usuario.getEstado(), usuario.getPais());
        }
}