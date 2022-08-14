package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.PedidoDto;
import br.com.camalCase.mudi.model.Pedido;
import br.com.camalCase.mudi.service.PedidoService;
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
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping()
    public ModelAndView home() {
        List<Pedido> pedidos = pedidoService.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos",pedidos);
        return mv;
    }

    @GetMapping("/getOne")
    public ResponseEntity<Object> savePedido(@RequestBody @Valid PedidoDto pedidoDto){
        var pedidos = new Pedido();
        BeanUtils.copyProperties(pedidoDto,pedidos);
        pedidos.setDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidos));

    }


}
