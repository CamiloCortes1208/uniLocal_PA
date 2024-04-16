package co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO;
public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}