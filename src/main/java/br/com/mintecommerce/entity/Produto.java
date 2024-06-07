package br.com.mintecommerce.entity;

import br.com.mintecommerce.Enum.EnumStatusProduto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private Float preco;
    private Integer quantidade;
    private Integer quantidadeestoque;
    @ManyToOne
    private Categoria categoria;
    private EnumStatusProduto status;
}
