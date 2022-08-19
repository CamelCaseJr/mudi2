package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.PedidoDto;
import br.com.camalCase.mudi.dto.ProdutoDto;
import br.com.camalCase.mudi.model.ItemPedido;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.service.PedidoService;
import br.com.camalCase.mudi.service.ProdutoService;
import br.com.camalCase.mudi.util.ClienteHttpUtil;
import br.com.camalCase.mudi.util.ConversorJsonForProdutoDtoUtil;
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
@RequestMapping("/home")
public class PedidoController {
    private final ProdutoService produtoService;
    private final PedidoService pedidoService;

    public PedidoController(ProdutoService produtoService, PedidoService pedidoService) {
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/home")
    public String home(Model model) throws IOException, InterruptedException {
        String url ="http://localhost:8081/produto/buscarTodos";
        String body = ClienteHttpUtil.ConectarAUmHttp(url);
        List<ProdutoDto> produtos = ConversorJsonForProdutoDtoUtil.extratorConteudo(body);

        model.addAttribute("produtos", produtos);
        return "home";
    }

    @GetMapping("/pedidos/formulario")
    public String formularioPedido (ProdutoDto produtoDto) {
        return "pedido/formulario";
    }

    @PostMapping("/pedido/novo")
    public String novoPedido(@Valid ProdutoDto produtoDto, BindingResult result){
        // caso não tenha preenchido algum campo, retorna para o formulário.
        if (result.hasErrors()){
            return "pedido/formulario";
        }
        System.out.println("Cadastrando novo pedido");

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
        return "pedido/formulario";
    }




}
