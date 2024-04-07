package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.InicioSesionClienteDTO;

public interface CuentaServicio {
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}
