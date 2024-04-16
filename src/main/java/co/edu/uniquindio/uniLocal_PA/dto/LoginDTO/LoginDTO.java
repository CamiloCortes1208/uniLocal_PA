package co.edu.uniquindio.uniLocal_PA.dto.LoginDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank @Email String email,
        @NotBlank  String password) {
}
