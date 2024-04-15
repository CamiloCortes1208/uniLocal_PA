package co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ItemNegocioDTO(
        @NotBlank String codigo,
        @NotBlank @Min(10) @Max(50) String nombre,
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotBlank CategoriaNegocio categoriaNegocio,
        Ubicacion ubicacion
) {
}
