package co.edu.uniquindio.uniLocal_PA.servicios.dto.moderadorDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InicioSesionModeradorDTO(
        @NotBlank @Email String email,
        @NotBlank  String password) {
}