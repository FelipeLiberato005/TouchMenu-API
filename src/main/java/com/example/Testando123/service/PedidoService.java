package com.example.Testando123.service;

import com.example.Testando123.model.Pedido;
import com.example.Testando123.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    public void imprime(Long id)
    {
        pedidoRepository.findById(id);
    }

    public Pedido salvar(String status, double valorTotal, long tempoEstimado, String dataHora)
    {
        Pedido pedido = new Pedido(status, valorTotal, tempoEstimado, dataHora);
        return pedidoRepository.save(pedido);
    }
}
