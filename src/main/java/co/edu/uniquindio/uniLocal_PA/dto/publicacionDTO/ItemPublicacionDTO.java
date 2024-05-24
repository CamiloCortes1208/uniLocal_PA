package co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record ItemPublicacionDTO(
        @NotBlank String codigoPublicacion,
        @NotBlank String codigoCliente,
        @NotBlank String descripcion,
        List<String> listaMeGustas,
        @NotBlank String rutaImagen,
        @NotBlank LocalDateTime fechaPublicacion
) {
}
