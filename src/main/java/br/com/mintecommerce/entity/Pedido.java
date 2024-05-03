package br.com.mintecommerce.entity;

import br.com.mintecommerce.Enum.EnumStatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "pedido")
@Entity(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date dataPedido;
    private EnumStatusPedido enumStatusPedido;
    private Float valorTotal;
    @ManyToOne
    private Usuario usuario;
    @OneToMany
    private List<Produto> produto;
}
