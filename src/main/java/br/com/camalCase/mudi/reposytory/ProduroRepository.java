package br.com.camalCase.mudi.reposytory;

import br.com.camalCase.mudi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProduroRepository extends JpaRepository<Produto, UUID> {
}
