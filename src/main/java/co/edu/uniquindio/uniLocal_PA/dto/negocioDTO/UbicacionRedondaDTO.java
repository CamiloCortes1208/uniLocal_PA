package co.edu.uniquindio.uniLocal_PA.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UbicacionRedondaDTO(
        @NotEmpty Ubicacion ubicacion,
        @NotNull @Min(1) int kmRedonda
) {
}
