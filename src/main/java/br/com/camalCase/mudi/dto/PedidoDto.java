package br.com.camalCase.mudi.dto;

import br.com.camalCase.mudi.model.Cliente;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PedidoDto {
    @NotBlank
    private Cliente cliente;
}
