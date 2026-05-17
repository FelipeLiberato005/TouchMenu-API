package com.example.Testando123.service;

import com.example.Testando123.model.Pedido;
import com.example.Testando123.model.Usuario;
import com.example.Testando123.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario resgistraUsuario(String user, String senha, String email)
    {
        Usuario usuario = new Usuario(user, senha, email);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscaUsuario(Long id)
    {
        return usuarioRepository.findById(id);
    }

    public void delete(Long id)
    {
        usuarioRepository.deleteById(id);
    }

    public void fazPedido(String status, double valorTotal, long tempoEstimado, String dataHora)
    {

        Pedido pedido = new Pedido(status, valorTotal, tempoEstimado, dataHora);
    }

    public List<Pedido> listPedido(long id)
    {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return usuario.getPedidos();

    }

}
