package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetalleClienteDTO(
        @NotBlank String id,
        @NotBlank String nombre,
        @NotBlank String fotoPerfil,
        @NotBlank String nickname,
        @NotBlank @Email String email,
        @NotBlank String ciudadResidencia,
        List<String> listaFavoritos,
        @NotNull EstadoRegistro estadoRegistro
) {
}
