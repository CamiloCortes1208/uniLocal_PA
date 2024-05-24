package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

import jakarta.validation.constraints.*;

public record RegistroClienteDTO(
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        String fotoPerfil,
        @NotBlank(message = "El apodo (nickname) es obligatorio") String nickname,
        @NotBlank(message = "El correo electrónico es obligatorio") @Email(message = "El correo electrónico debe tener un formato válido") String email,
        @NotBlank(message = "La contraseña es obligatoria") String password,
        @NotBlank(message = "La contraseña es obligatoria") String confirmarPassword,
        @NotBlank(message = "La ciudad de residencia es obligatoria") String ciudadResidencia
) {


}