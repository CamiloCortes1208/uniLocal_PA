package co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InicioSesionClienteDTO(
        @NotBlank @Email String email,
        @NotBlank  String password
)  {

}