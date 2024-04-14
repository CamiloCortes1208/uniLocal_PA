package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;

import java.util.List;

public interface ClienteServicio extends CuentaServicio{

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    ItemClienteDTO obtenerCliente(String idCliente) throws Exception;
    List<ItemClienteDTO> listarClientes();
    void agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception;
    void eliminarNegocioFavorito(String idCliente, String idNegocio) throws Exception;



}