package co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

public record ItemCalificacionDTO(
        @NotBlank(message = "El id de la calificacion es obligatorio") String codigoCalificacion,
        @NotBlank(message = "El id del negocio es obligatorio") String codigoNegocio,
        @NotBlank(message = "El id del cliente es obligatorio") String codigoCliente,
        @NotNull(message = "Debe colocar una fecha") LocalDateTime fecha,
        @NotBlank @Range(min = 1, max = 5, message = "La calificación debe estar entre 1 y 5") int valoracion,
        @NotBlank @Min(value = 20, message = "El mensaje debe ser minimo de 20 letras") @Max(value = 300,message = "El mensaje debe ser maximo de 300 letras")String mensaje,
        String respuesta) {
}
