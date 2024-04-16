package co.edu.uniquindio.uniLocal_PA.dto.excepcionDTO;

import jakarta.validation.constraints.NotBlank;

public record ValidacionDTO(
        @NotBlank String campo,
        @NotBlank String error
) {
}
