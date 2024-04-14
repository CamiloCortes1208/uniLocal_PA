package co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ItemCalificacionDTO(
        @NotBlank LocalDateTime fecha,
        @NotBlank int valoracion,
        @NotBlank @Min(20) @Max(300) String mensaje) {
}
