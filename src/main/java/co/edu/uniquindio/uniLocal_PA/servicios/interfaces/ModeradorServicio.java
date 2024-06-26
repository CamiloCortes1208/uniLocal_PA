package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;

public interface ModeradorServicio {
    void actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception;

    boolean existeModerador(String codigoModerador);
}
