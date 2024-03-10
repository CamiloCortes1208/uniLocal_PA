package co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.TipoEvento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AgregarEventoDTO(
        @NotBlank @Min(10) @Max(30) String nombre,
        @NotBlank @Min(30) @Max(300) String descripcion,
        @NotBlank TipoEvento tipoEvento

        //Revisar lo de horario
        ) {
}
