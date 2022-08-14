package br.com.camalCase.mudi.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


public class ProdutoDto {
    @NotBlank
    private String valor;
    @NotBlank
    private String nome;
    @Lob
    @NotBlank
    @Column(length = 2147483647)
    private String urlProduto;
    @Lob
    @NotBlank
    @Column(length = 2147483647)
    private String urlImagem;
    @NotBlank
    private String descricao;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

