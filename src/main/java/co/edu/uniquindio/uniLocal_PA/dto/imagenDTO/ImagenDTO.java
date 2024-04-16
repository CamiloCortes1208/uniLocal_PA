package co.edu.uniquindio.uniLocal_PA.dto.imagenDTO;

import jakarta.validation.constraints.NotBlank;

public record ImagenDTO(
        @NotBlank String id,
        @NotBlank String url
) {
}
