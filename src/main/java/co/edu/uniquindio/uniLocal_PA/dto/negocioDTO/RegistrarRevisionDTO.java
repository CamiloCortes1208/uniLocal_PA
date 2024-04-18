package co.edu.uniquindio.uniLocal_PA.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarRevisionDTO(
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotNull EstadoNegocio estadoNegocio
) {
}
