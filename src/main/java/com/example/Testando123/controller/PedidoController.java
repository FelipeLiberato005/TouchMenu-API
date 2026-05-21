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

    @GetMapping("{id}")
    public void imprimirPedido(@PathVariable Long id)
    {
        pedidoService.imprime(id);
    }

    @PostMapping("/usuarios/{id}")
    public ResponseEntity<Pedido> criarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedido1 = pedidoService.criarPedido(id, pedido.getTempoEstimado(), pedido.getStatus(), pedido.getValorTotal());
        return ResponseEntity.status(201).body(pedido1);
    }

    @PatchMapping("/alterarPedido/{id}")
    public void mudaStatus(@PathVariable Long id, @RequestBody Pedido pedido)
    {
            pedidoService.mudaStatus(id, pedido.getStatus());
    }

}
