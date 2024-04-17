package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.LoginClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.LoginModeradorDTO;

public interface InicioSesionServicio {
    void inicioSesionCliente(LoginClienteDTO loginClienteDTO);

    void inicioSesionModerador(LoginModeradorDTO loginModeradorDTO);

    void enviarLinkRecuperacion(String email) throws Exception;
}
