package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;

public record ActualizarClienteDTO(
        @NotBlank(message = "El id del cliente no puede ser nulo") String id,
        @NotBlank(message = "Es necesario el nombre del cliente") String nombre,
        @NotBlank(message = "Es necesario el url de la foto de perfil del cliente") String fotoPerfil,
        @NotBlank(message = "Es necesario el email del cliente") String email,
        @NotBlank(message = "Es necesario la ciudad de residencia del cliente") String ciudadResidencia
) {


}