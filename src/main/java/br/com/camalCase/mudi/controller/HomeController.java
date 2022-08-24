package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.model.ItemPedido;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.model.StatusPedido;
import br.com.camalCase.mudi.service.ItemPedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final ItemPedidoService itemPedidoService;

    public HomeController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }
    @GetMapping()
    public String home(Model model) throws IOException, InterruptedException {
/*        String url ="http://localhost:8081/produto/buscarTodos";
        String body = ClienteHttpUtil.ConectarAUmHttp(url);
        List<ProdutoDto> produtos = ConversorJsonForProdutoDtoUtil.extratorConteudo(body);*/

        List<ItemPedido> itemPedidos = itemPedidoService.findAll();
        model.addAttribute("itemPedidos", itemPedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String listandoPorStatus(@PathVariable("status") String status, Model model){

        List<ItemPedido> itemPedidos = itemPedidoService.findAll().stream()
                .filter(itemPedido ->  itemPedido.getPedido()
                            .getStatus()
                            .equals(StatusPedido.valueOf(status.toUpperCase())))
                .collect(Collectors.toList());

        model.addAttribute("itemPedidos", itemPedidos);
        model.addAttribute("status",status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }

}
