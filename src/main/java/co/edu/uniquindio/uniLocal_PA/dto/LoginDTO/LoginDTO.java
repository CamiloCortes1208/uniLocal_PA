package co.edu.uniquindio.uniLocal_PA.dto.LoginDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "El campo 'email' no puede estar vacío") @Email(message = "Debe proporcionar un email válido") String email,
        @NotBlank(message = "El campo 'password' no puede estar vacío") String password) {
}