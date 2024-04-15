package co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DetalleClienteDTO(
        @NotBlank String id,
        @NotBlank String nombre,
        @NotBlank String fotoPerfil,
        @NotBlank String nickname,
        @NotBlank String email,
        @NotBlank String ciudadResidencia,
        List<String> listaFavoritos
) {
}
