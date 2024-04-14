package co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ItemNegocioDTO(
        @NotBlank @Min(10) @Max(50) String nombreNegocio,
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotBlank CategoriaNegocio categoriaNegocio,

        //Revisar lo de la lista de imagenes de negocio
        @NotEmpty List<String> listaImagenesNegocio,
        //Revisar lo de lista de telefonos
        List<String> listaTelefonos,
        //Revisar lo de horarios
        @NotEmpty List<Horario> listaHorarios
) {
}
