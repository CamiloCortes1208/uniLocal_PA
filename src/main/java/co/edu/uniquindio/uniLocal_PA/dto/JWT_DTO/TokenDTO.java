package co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO;

import jakarta.validation.constraints.NotBlank;
public record TokenDTO (
        @NotBlank
        String token
){
}
