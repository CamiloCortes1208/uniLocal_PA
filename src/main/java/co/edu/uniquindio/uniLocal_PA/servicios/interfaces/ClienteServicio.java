package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.RegistroClienteDTO;

public interface ClienteServicio extends CuentaServicio{

    void registrarse(RegistroClienteDTO registroClienteDTO)throws Exception;

    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;

}