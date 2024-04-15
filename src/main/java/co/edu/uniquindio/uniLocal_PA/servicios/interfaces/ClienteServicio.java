package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.AgregarPublicacionDTO;

import java.util.List;

public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    ItemClienteDTO obtenerCliente(String idCliente) throws Exception;
    List<ItemClienteDTO> listarClientes();
    String agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}