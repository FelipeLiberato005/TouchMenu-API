package com.example.Testando123.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@NotBlank
public class UsuarioDto {
    public record UsuarioRequestDTO(

            @NotBlank(message = "O usuário é obrigatório.")
            String user,

            @NotBlank(message = "A senha é obrigatória.")
            @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
            String senha,

            @NotBlank(message = "O e-mail é obrigatório.")
            @Email(message = "O e-mail deve ser válido.")
            @Pattern(
                    regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
                    message = "O formato do e-mail é inválido."
            )
            String email
    ) {}
}
