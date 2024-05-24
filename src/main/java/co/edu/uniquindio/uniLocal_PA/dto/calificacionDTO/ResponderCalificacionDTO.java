package co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ResponderCalificacionDTO(
        @NotBlank(message = "Es necesario el id de la calificacion") String idCalificacion,
        @NotBlank @Min(value = 20, message = "La respuesta debe ser minimo de 20 letras") @Max(value = 300,message = "La respuesta debe ser maximo de 300 letras") String respuesta
) {
}
