package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.SesionDTO;

public interface CuentaServicio {
    void iniciarSesion(SesionDTO sesionDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}
