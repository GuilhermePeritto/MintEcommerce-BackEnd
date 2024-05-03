package br.com.mintecommerce.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "carrinho")
@Entity(name = "carrinho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Float valorTotal;
    @ManyToOne
    private Usuario usuario;
    @Nullable
    private UUID idPedido;
    @OneToMany
    private List<Produto> produtos;
}