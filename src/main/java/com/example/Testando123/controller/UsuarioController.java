package com.example.Testando123.controller;

import com.example.Testando123.DTO.UsuarioDto;
import com.example.Testando123.Exceptions.EmailInvalido;
import com.example.Testando123.Filtr.FiltroEmail;
import com.example.Testando123.model.Usuario;
import com.example.Testando123.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> register(@RequestBody UsuarioDto.UsuarioRequestDTO dados)
    {
        FiltroEmail filtroEmail = new FiltroEmail();
        try {
            boolean b = filtroEmail.filtraTel(dados.email());
            if (b == true && dados.user()!=null)
            {
                Usuario usuarioSalvo = usuarioService.resgistraUsuario(dados.user(), dados.senha(), dados.email());

                return ResponseEntity.ok(usuarioSalvo);
            }
            else
            {
                throw new EmailInvalido();
            }

        } catch (EmailInvalido e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUser(@PathVariable Long id)
    {
        Optional<Usuario> usuario = usuarioService.buscaUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        usuarioService.delete(id);
    }

}
