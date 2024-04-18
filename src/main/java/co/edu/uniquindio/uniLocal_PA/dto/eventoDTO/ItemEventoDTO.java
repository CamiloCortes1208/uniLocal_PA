package co.edu.uniquindio.uniLocal_PA.dto.eventoDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.TipoEvento;
import jakarta.validation.constraints.*;

import java.util.List;

public record ItemEventoDTO(
        @NotBlank String codigoEvento,
        @NotBlank String codigoNegocio,
        @NotBlank @Min(10) @Max(30) String nombre,
        @NotBlank @Min(30) @Max(300) String descripcion,
        @NotBlank TipoEvento tipoEvento,
        @NotEmpty List<Horario> diasDisponible,
        @NotNull EstadoEvento estadoEvento
) {
}
