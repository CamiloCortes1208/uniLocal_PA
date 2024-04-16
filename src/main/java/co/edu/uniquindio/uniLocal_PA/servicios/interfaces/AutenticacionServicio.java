package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.TokenDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.LoginClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.LoginModeradorDTO;

public interface AutenticacionServicio {

    TokenDTO iniciarSesionCliente(LoginClienteDTO loginClienteDTO) throws Exception;

    TokenDTO iniciarSesionModerador(LoginModeradorDTO loginModeradorDTO) throws Exception;
}
