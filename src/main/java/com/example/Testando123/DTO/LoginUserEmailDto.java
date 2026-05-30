package com.example.Testando123.DTO;

public class LoginUserEmailDto {
    public record UsuarioResponseDTO(
            Long id,
            String email,
            String user
    ) {}
}
