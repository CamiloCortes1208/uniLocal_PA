package co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO;

import jakarta.validation.constraints.NotBlank;

public record ReaccionarPublicacionDTO(
        @NotBlank String idPublicacion,
        @NotBlank String idCliente
) {
}
