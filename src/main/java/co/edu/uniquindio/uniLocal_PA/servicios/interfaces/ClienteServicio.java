package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;

import java.util.List;

public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception;

    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception;

    void eliminarCliente(String idCuenta) throws Exception;

    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception;

    boolean existeCliente(String idCliente);

    List<ItemClienteDTO> listarClientes();

    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception;

    Cliente obtenerClienteID(String idCliente) throws ResourceNotFoundException;

    void actualizarFavoritos(Cliente cliente);


}