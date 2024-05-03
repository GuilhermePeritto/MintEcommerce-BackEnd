package br.com.mintecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "imagem")
@Entity(name = "imagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Lob
    private byte[] imagem;
}