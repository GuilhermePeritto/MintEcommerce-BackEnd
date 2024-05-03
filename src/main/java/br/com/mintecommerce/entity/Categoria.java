package br.com.mintecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "categoria")
@Entity(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
}
