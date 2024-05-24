package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.DetalleModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;

public interface ModeradorServicio {
    void actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception;

    boolean existeModerador(String codigoModerador);

    DetalleModeradorDTO obtenerModerador(String codigoModerador) throws Exception;
}
