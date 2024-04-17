package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

public record CambioPasswordDTO(
        String passwordVieja,
        String passwordNueva,
        String id
) {
}