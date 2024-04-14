package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;

public interface ClienteServicio extends CuentaServicio{

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;

    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;

    ItemClienteDTO obtenerCliente(String idCliente) throws Exception;

}