package br.com.camalCase.mudi.reposytory;

import br.com.camalCase.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PedidosRepository extends JpaRepository<Pedido, UUID> {
}
