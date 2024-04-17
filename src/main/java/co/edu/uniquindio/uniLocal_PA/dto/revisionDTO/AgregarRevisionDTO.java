package co.edu.uniquindio.uniLocal_PA.dto.revisionDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgregarRevisionDTO(
        @NotBlank LocalDateTime fecha,
        @NotBlank String codigoModerador,
        @NotBlank String codigoNegocio,
        @NotBlank String descripcion,
        @NotBlank EstadoNegocio estadoNegocio
) {
}
