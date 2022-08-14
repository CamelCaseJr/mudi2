package br.com.camalCase.mudi.model;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private UUID idCliente;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente() {
    }
}
