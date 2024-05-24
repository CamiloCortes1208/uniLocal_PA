package co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleModeradorDTO(
        @NotBlank String idCodigoModerador,
        @NotBlank String nombre,
        @NotBlank String rutaFotoPerfil,
        @NotBlank @Email String email,
        @NotNull EstadoRegistro estadoRegistro
) {
}
