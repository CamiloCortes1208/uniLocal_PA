package co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record ActualizarCalificacionDTO(
        @NotBlank(message = "El id de la calificacion es obligatorio") String idCalificacion,
        @NotBlank @Range(min = 1, max = 5, message = "La calificación debe estar entre 1 y 5") int valoracion,
        @NotBlank @Min(value = 20, message = "El mensaje debe ser minimo de 20 letras") @Max(value = 300,message = "El mensaje debe ser maximo de 300 letras") String mensaje
) {
}
