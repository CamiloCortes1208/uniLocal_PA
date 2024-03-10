package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.SesionDTO;

public interface CuentaServicio {
    void iniciarSesion(SesionDTO sesionDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}
