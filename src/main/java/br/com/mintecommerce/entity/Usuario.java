package br.com.mintecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String endereco;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
}
