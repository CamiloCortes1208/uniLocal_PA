package co.edu.uniquindio.uniLocal_PA.dto.eventoDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.TipoEvento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DetalleEventoDTO(
        @NotBlank String codigoEvento,
        @NotBlank String codigoNegocio,
        @NotBlank @Min(10) @Max(30) String nombre,
        @NotBlank @Min(30) @Max(300) String descripcion,
        @NotBlank TipoEvento tipoEvento,
        @NotBlank List<Horario> diasDisponible,
        @NotBlank EstadoEvento estadoEvento
) {
}
