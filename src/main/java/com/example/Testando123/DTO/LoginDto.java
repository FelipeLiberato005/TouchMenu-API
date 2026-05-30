package com.example.Testando123.DTO;

public class LoginDto {
    public record UsuarioResponseDTO(
            Long id,
            String email,
            String senha
    ) {}
}
