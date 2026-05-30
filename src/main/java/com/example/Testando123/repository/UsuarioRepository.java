package com.example.Testando123.repository;

import com.example.Testando123.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUser(String user);

    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
