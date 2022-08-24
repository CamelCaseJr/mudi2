package br.com.camalCase.mudi.service;

import br.com.camalCase.mudi.model.ItemPedido;
import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.model.StatusPedido;
import br.com.camalCase.mudi.reposytory.ItemPedidoRepository;
import br.com.camalCase.mudi.reposytory.ProduroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> findById(Long id) {
        return itemPedidoRepository.findById(id);
    }

    public Object save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void delete(ItemPedido itemPedido) {
        itemPedidoRepository.delete(itemPedido);
    }

    public List<ItemPedido> findByPedidoStatus(StatusPedido valueOf) {
        return  itemPedidoRepository.findByPedidoStatus(valueOf);
    }
}
