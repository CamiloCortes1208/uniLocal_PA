package co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ComentarPublicacionDTO(
        @NotBlank @Min(30) @Max(300) String mensaje
) {
}
