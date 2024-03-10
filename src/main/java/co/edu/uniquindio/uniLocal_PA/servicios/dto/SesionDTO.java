package co.edu.uniquindio.uniLocal_PA.servicios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SesionDTO(
        @NotBlank String email,
        @NotBlank @Email String password
)  {

}
