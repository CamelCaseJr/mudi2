package br.com.camalCase.mudi.service;

import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.reposytory.ProduroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProduroRepository produroRepository;

    public ProdutoService(ProduroRepository produroRepository) {
        this.produroRepository = produroRepository;
    }

    public List<Produto> findAll() {
        return produroRepository.findAll();
    }

    public Optional<Produto> findById(UUID id) {
        return produroRepository.findById(id);
    }

    public Object save(Produto produtos) {
        return produroRepository.save(produtos);
    }

    public void delete(Produto produto) {
        produroRepository.delete(produto);
    }
}
