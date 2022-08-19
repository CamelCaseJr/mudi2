package br.com.camalCase.mudi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "tb_item_pedido")
@Data
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_unitario")
    private Double precoUnitario;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
        this.precoUnitario = Double.parseDouble(produto.getValor());
    }
}
