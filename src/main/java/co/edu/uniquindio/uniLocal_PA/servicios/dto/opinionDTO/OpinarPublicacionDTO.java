package co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OpinarPublicacionDTO(
        @NotBlank @Min(1) @Max(300) String mensaje
) {
}