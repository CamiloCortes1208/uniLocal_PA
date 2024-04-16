package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginClienteDTO(
        @NotBlank @Email String email,
        @NotBlank  String password
)  {

}
