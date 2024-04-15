package co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record ActualizarCalificacionDTO(
        @NotBlank String idCalificacion,
        @NotBlank @Range(min = 1, max = 5) int valoracion,
        @NotBlank @Min(20) @Max(300) String mensaje
) {
}
