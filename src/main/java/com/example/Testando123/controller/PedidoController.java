package com.example.Testando123.controller;

import com.example.Testando123.DTO.PedidoDto;
import com.example.Testando123.model.Pedido;
import com.example.Testando123.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    public ResponseEntity<Pedido> registrarPedido(@RequestBody PedidoDto.ProdutosRequestDTO dados)
    {
        Pedido pedido = pedidoService.salvar(dados.status(),
                                        dados.valorTotal(),
                                        dados.tempoEstimado(),
                                        dados.dataHora());

        return ResponseEntity.ok(pedido);
    }


    @GetMapping("{id}")
    public void imprimirPedido(@PathVariable Long id)
    {
        pedidoService.imprime(id);
    }
}
