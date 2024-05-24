package co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO;

import jakarta.validation.constraints.NotBlank;

public record ReaccionarPublicacionDTO(
        @NotBlank(message = "Es necesario el id de la publicacion") String idPublicacion,
        @NotBlank(message = "Es necesario el id del cliente") String idCliente
) {
}
