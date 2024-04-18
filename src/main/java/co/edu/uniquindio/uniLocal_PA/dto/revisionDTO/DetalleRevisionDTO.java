package co.edu.uniquindio.uniLocal_PA.dto.revisionDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleRevisionDTO(
        @NotBlank String codigoRevision,
        @NotNull LocalDateTime fecha,
        @NotBlank String codigoModerador,
        @NotBlank String codigoNegocio,
        @NotBlank String descripcion,
        @NotNull EstadoNegocio estadoNegocio
) {
}
