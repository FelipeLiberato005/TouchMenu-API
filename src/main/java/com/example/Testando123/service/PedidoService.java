package com.example.Testando123.service;

import com.example.Testando123.model.Pedido;
import com.example.Testando123.model.Usuario;
import com.example.Testando123.repository.PedidoRepository;
import com.example.Testando123.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

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
        pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não existe"));
    }


    public Pedido criarPedido(Long usuarioId, long tempoEstimado, String status, Double valor) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String pattern = "HH:mm:ss 'de' dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dataHora = simpleDateFormat.format(new Date());

        Pedido pedido = new Pedido();
        pedido.setValorTotal(valor);
        pedido.setStatus(status);
        pedido.setDataHora(dataHora);
        pedido.setTempoEstimado(tempoEstimado);
        pedido.setUsuario(usuario);
        usuario.setPedidos(Collections.singletonList(pedido));

        return pedidoRepository.save(pedido);
    }

    public Pedido mudaStatus(Long id, String novoStatus)
    {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não existe"));
        pedido.setStatus(novoStatus);
        return  pedidoRepository.save(pedido);
    }


}
