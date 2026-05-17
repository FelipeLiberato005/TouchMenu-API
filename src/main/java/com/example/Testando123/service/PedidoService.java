package com.example.Testando123.service;

import com.example.Testando123.model.Pedido;
import com.example.Testando123.model.Usuario;
import com.example.Testando123.repository.PedidoRepository;
import com.example.Testando123.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;



    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public void imprime(Long id)
    {
        pedidoRepository.findById(id);
    }


    public Pedido criarPedido(Long usuarioId, long tempoEstimado, String dataHora, String status, Double valor) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setValorTotal(valor);
        pedido.setStatus(status);
        pedido.setDataHora(dataHora);
        pedido.setTempoEstimado(tempoEstimado);
        pedido.setUsuario(usuario);
        usuario.setPedidos(Collections.singletonList(pedido));

        return pedidoRepository.save(pedido);
    }
}
