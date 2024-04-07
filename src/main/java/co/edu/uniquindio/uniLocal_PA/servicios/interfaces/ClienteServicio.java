package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.DetalleClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;

public interface ClienteServicio extends CuentaServicio{

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;

    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;

    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception;

}