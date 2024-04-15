package co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgregarPublicacionDTO(
        @NotBlank @Min(30) @Max(500) String descripcion,
        @NotBlank String rutaImagen,
        @NotBlank String idCliente,
        @NotBlank LocalDateTime fechaPublicacion
        //Revisar lo de imagenes
) {
}
