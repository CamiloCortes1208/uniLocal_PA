package co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

public record AgregarPublicacionDTO(
        @NotBlank @Range(min = 30, max = 100, message = "Debe tener al menos 30 caracteres y menos de 100") String descripcion,
        @NotBlank(message = "Es necesario la ruta de la imagen") String rutaImagen,
        @NotBlank(message = "Es necesario el id del cliente") String idCliente
        //Revisar lo de imagenes
) {
}
