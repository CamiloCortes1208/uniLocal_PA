package co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginModeradorDTO(
        @NotBlank @Email String email,
        @NotBlank String password) {
}
