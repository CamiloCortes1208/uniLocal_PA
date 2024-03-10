package co.edu.uniquindio.uniLocal_PA.servicios.dto;

public record CambioPasswordDTO(
        String passwordNueva,
        String id,
        String token
) {
}