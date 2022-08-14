package br.com.camalCase.mudi.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_produtos")
@Setter
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String valor;
    private String nome;
    @Lob
    @Column(name = "url_produto", length = 2147483647)
    private String urlProduto;
    @Lob
    @Column(name = "url_imagem", length = 2147483647)
    private String urlImagem;
    private String descricao;
}
