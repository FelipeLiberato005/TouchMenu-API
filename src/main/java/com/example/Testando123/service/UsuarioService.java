package com.example.Testando123.service;

import com.example.Testando123.model.Usuario;
import com.example.Testando123.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

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



}
