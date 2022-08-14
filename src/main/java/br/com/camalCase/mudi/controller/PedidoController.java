package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.PedidoDto;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.service.PedidoService;
import br.com.camalCase.mudi.service.ProdutoService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/home")
public class PedidoController {
    private final ProdutoService produtoService;

    public PedidoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produtos", produtos);
        return "home";
    }




}
