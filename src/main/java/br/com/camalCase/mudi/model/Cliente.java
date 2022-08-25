package br.com.camalCase.mudi.model;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class Cliente {
    @Id
    private String username;
    private String password;
    private boolean enabled;


    public Cliente() {
    }
}
