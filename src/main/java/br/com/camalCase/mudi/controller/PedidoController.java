package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.ProdutoDto;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.service.PedidoService;
import br.com.camalCase.mudi.service.ProdutoService;
import br.com.camalCase.mudi.util.ClienteHttpUtil;
import br.com.camalCase.mudi.util.ConversorJsonForProdutoDtoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        String url ="http://localhost:8080/produto/buscarTodos";
        String body = ClienteHttpUtil.ConectarAUmHttp(url);
        List<ProdutoDto> produtos = ConversorJsonForProdutoDtoUtil.extratorConteudo(body);

        model.addAttribute("produtos", produtos);
        return "home";
    }




}
