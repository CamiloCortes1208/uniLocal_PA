package co.edu.uniquindio.uniLocal_PA.dto.opinionDTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record ItemOpinionDTO(
        @NotBlank String codigoCliente,
        @NotBlank String codigoOpinion,
        @NotBlank String codigoPublicacion,
        @NotBlank String mensaje,
        @NotBlank LocalDateTime fecha,
        List<String> listaMeGustas
) {
}
