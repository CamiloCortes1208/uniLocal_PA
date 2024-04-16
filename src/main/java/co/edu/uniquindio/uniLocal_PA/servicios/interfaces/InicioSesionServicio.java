package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.InicioSesionClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.InicioSesionModeradorDTO;

public interface InicioSesionServicio {
    void inicioSesionCliente(InicioSesionClienteDTO inicioSesionClienteDTO);
    void inicioSesionModerador(InicioSesionModeradorDTO inicioSesionModeradorDTO);
    void enviarLinkRecuperacion(String email)throws Exception;
}
