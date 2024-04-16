package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.TokenDTO;
import co.edu.uniquindio.uniLocal_PA.dto.LoginDTO.LoginDTO;

public interface AutenticacionServicio {

    TokenDTO iniciarSesionCliente(LoginDTO loginDTO) throws Exception;

    TokenDTO iniciarSesionModerador(LoginDTO loginDTO) throws Exception;
}
