package com.example.Testando123.controller;

import com.example.Testando123.DTO.LoginDto;
import com.example.Testando123.DTO.LoginUserEmailDto;
import com.example.Testando123.DTO.PedidoDto;
import com.example.Testando123.DTO.UsuarioDto;
import com.example.Testando123.Exceptions.EmailInvalido;
import com.example.Testando123.Filtr.FiltroEmail;
import com.example.Testando123.model.Pedido;
import com.example.Testando123.model.Usuario;
import com.example.Testando123.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Valid
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
// 1. Adicionado o @Valid para ativar as validações do seu Record
    public ResponseEntity<Usuario> register(@Valid @RequestBody UsuarioDto.UsuarioRequestDTO dados) throws EmailInvalido {


        Usuario usuarioSalvo = usuarioService.resgistraUsuario(dados.user(), dados.senha(), dados.email());
        return ResponseEntity.ok(usuarioSalvo);
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


    @GetMapping("pedidosUser/{id}")
    public ResponseEntity<List<Pedido>> buscarPedido(@PathVariable Long id)
    {
        List<Pedido> pedidos = usuarioService.listPedido(id);
        return ResponseEntity.ok(pedidos);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto.UsuarioResponseDTO dados) {
        Optional<Usuario> usuario = usuarioService.fazLogin(dados.email(), dados.senha());

        if (usuario.isPresent()) {
            Usuario u = usuario.get();
            LoginUserEmailDto.UsuarioResponseDTO resposta =
                    new LoginUserEmailDto.UsuarioResponseDTO(
                    u.getId(),
                    u.getEmail(),
                    u.getUser()
            );
            return ResponseEntity.ok(resposta);

        }

        return ResponseEntity.status(401).body("Email ou Senha invalido");
    }
}
