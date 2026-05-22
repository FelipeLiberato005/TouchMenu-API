package com.example.Testando123.controller;

import com.example.Testando123.DTO.ProdutosDto;
import com.example.Testando123.model.Produtos;
import com.example.Testando123.service.ProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutosController {


    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping("/")
    public ResponseEntity<Produtos> registrarProduto(@RequestBody ProdutosDto.ProdutosRequestDTO dados)
    {
        Produtos salvar = produtosService.salvar(dados.nome(),
                                                dados.descricao(),
                                                dados.valorTotal(),
                                                dados.tempoEstimado());

        return ResponseEntity.ok((Produtos) salvar);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id)
    {
        produtosService.deletar(id);
    }

    @GetMapping
    public ResponseEntity<?> listarProdutos()
    {
        List<Produtos> listar = produtosService.listar();
        return ResponseEntity.ok(listar);
    }
}
