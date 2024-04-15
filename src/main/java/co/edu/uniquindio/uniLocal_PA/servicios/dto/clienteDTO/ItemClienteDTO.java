package co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO;

import java.util.List;

public record ItemClienteDTO(
        String codigo,
        String nombre,
        String fotoPerfil,
        String nickname,
        String email,
        String ciudadResidencia,
        List<String> listaNegociosFavoritos
){
}
