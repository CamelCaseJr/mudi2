package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.ProdutoDto;
import br.com.camalCase.mudi.model.ItemPedido;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.model.StatusPedido;
import br.com.camalCase.mudi.service.ItemPedidoService;
import br.com.camalCase.mudi.service.PedidoService;
import br.com.camalCase.mudi.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    private final ProdutoService produtoService;
    private final PedidoService pedidoService;


    public PedidoController(ProdutoService produtoService, PedidoService pedidoService) {
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
    }


    @GetMapping("/formulario")
    public String formularioPedido (ProdutoDto produtoDto) {
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid ProdutoDto produtoDto, BindingResult result){
        // caso não tenha preenchido algum campo, retorna para o formulário.
        if (result.hasErrors()){
            return "pedido/formulario";

        }

        System.out.println("Cadastrando novo pedido");
        // parse para produto
        var produto = produtoDto.toProduto();

        System.out.println("Criando pedido");
        var pedido = new Pedido();

        System.out.println("Criando item do pedido");
        var itemPedido = new ItemPedido(pedido,produto);
        pedido.adicionarItem(itemPedido);

        System.out.println("Salvando no banco de dados");
        produtoService.save(produto);

        System.out.println("salvando pedido");
        pedidoService.save(pedido);

        return "redirect:/home";
    }




}
