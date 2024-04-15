package co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ItemOpinionDTO(
        String codigoCliente,
        String codigoOpinion,
        String mensaje,
        LocalDateTime fecha,
        List<String> cantidadMeGusta
) {
}
