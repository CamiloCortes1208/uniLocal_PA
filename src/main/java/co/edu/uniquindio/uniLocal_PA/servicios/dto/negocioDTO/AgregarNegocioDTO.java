package co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record AgregarNegocioDTO(
        @NotBlank @Min(10) @Max(50) String nombreNegocio,
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotBlank CategoriaNegocio categoriaNegocio

        //Revisar lo de la lista de imagenes de negocio
        //Revisar lo de lista de telefonos
        //Revisar lo de horarios
) {
}
