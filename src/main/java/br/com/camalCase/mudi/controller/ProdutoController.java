package br.com.camalCase.mudi.controller;

import br.com.camalCase.mudi.dto.ProdutoDto;
import br.com.camalCase.mudi.model.Produto;
import br.com.camalCase.mudi.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Produto>>buscarTodosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProId(@PathVariable (value = "id")UUID id){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto,produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto,produto);
        produto.setId(produtoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable (value = "id")UUID id){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoService.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(" deleted successfully.");
    }
    

}
