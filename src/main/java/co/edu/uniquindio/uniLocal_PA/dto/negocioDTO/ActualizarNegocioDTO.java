package co.edu.uniquindio.uniLocal_PA.dto.negocioDTO;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record ActualizarNegocioDTO(
        @NotBlank String codigoCliente,
        @NotBlank String codigoNegocio,
        @NotBlank @Size(min = 10, max = 50) String nombreNegocio,
        @NotBlank @Size(max = 300) String descripcion,
        @NotNull CategoriaNegocio categoriaNegocio,
        @NotEmpty(message = "La lista de imágenes no puede estar vacía") @Size(min = 1, max = 10, message = "La lista de imágenes debe tener entre 1 y 10 elementos") List<@NotBlank @Size(max = 100) String> listaImagenesNegocio,
        @NotEmpty(message = "La lista de teléfonos no puede estar vacía") @Size(min = 1, max = 5, message = "La lista de teléfonos debe tener entre 1 y 5 elementos") List<@NotBlank @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos numéricos") String> listaTelefonos,
        @NotEmpty(message = "La lista de horarios no puede estar vacía") @Size(min = 1, max = 7, message = "La lista de horarios debe tener entre 1 y 7 elementos") List<@Valid Horario> listaHorarios,
        @NotNull(message = "La ubicación no puede ser nula") @Valid Ubicacion ubicacion
) {
}
