package co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO;

public record CambioPasswordDTO(
        String passwordNueva,
        String id,
        String token
) {
}