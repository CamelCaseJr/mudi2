package br.com.camalCase.mudi.reposytory;

import br.com.camalCase.mudi.model.ItemPedido;
import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    List<ItemPedido> findByPedidoStatus(StatusPedido valueOf);
}
