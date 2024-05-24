package co.edu.uniquindio.uniLocal_PA.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record CambioPasswordDTO(
        @NotBlank(message = "Es necesario indicar la contraseña actual") @Range(min = 5, message = "la constraseña debe tener un tamaño minimo de 5 letras") String passwordVieja,
        @NotBlank(message = "Es necesario indicar la contraseña actual") @Range(min = 5, message = "la constraseña debe tener un tamaño minimo de 5 letras") String passwordNueva,
        @NotBlank(message = "Es necesario indicar el id del usuario") String id
) {
}