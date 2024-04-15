package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.AgregarPublicacionDTO;

import java.util.List;

public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO)throws Exception;
    void eliminarCuenta(String idCuenta)throws Exception;
    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception;
    boolean existeCliente(String idCliente);
    List<ItemClienteDTO> listarClientes();
    String agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
}