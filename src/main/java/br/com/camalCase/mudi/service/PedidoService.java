package br.com.camalCase.mudi.service;

import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.reposytory.PedidosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidosRepository pedidosRepository;

    public PedidoService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }


    public List<Pedido> findAll() {
        return pedidosRepository.findAll();
    }

    public Object save(Pedido pedido) {
        return pedidosRepository.save(pedido);
    }
}
