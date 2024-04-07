package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {
    private final ClienteRepo clienteRepo;
    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {
        //Se crea el objeto Cliente
        Cliente cliente = new Cliente();
        //Se le asignan sus campos
        cliente.setNombre( registroClienteDTO.nombre() );
        cliente.setNickname( registroClienteDTO.nickname() );
        cliente.setCiudadResidencia( registroClienteDTO.ciudadResidencia() );
        cliente.setFotoPerfil( registroClienteDTO.fotoPerfil() );
        cliente.setEmail( registroClienteDTO.email() );
        cliente.setPassword( registroClienteDTO.password() );
        cliente.setEstadoRegistro(EstadoRegistro.ACTIVO);
        //Se guarda en la base de datos y obtenemos el objeto registrado
        Cliente clienteGuardado = clienteRepo.save(cliente);
        //Retornamos el id (código) del cliente registrado
        return clienteGuardado.getCodigoCliente();
    }

    @Override
    public void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception {
        //Buscamos el cliente que se quiere actualizar
        Optional<Cliente> optionalCliente = clienteRepo.findById( actualizarClienteDTO.id() );
        //Si no se encontró el cliente, lanzamos una excepción
        if(optionalCliente.isEmpty()){
            throw new Exception("No se encontró el cliente a actualizar");
        }
        //Obtenemos el cliente que se quiere actualizar y le asignamos los nuevos valores (el
        //nickname no se puede cambiar)
        Cliente cliente = optionalCliente.get();
        cliente.setNombre( actualizarClienteDTO.nombre() );
        cliente.setFotoPerfil( actualizarClienteDTO.fotoPerfil() );
        cliente.setEmail( actualizarClienteDTO.email() );
        cliente.setCiudadResidencia( actualizarClienteDTO.ciudadResidencia() );
        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro sino que
        // actualiza el que ya existe
        clienteRepo.save(cliente);
    }

    @Override
    public DetalleClienteDTO obtenerCliente(String idCliente) throws Exception {
        //Buscamos el cliente que se quiere eliminar
        Optional<Cliente> optionalCliente = clienteRepo.findById( idCliente );
        //Si no se encontró el cliente, lanzamos una excepción
        if(optionalCliente.isEmpty()){
            throw new Exception("No se encontró el cliente a con el id "+idCliente);
        }
        //Obtenemos el cliente
        Cliente cliente = optionalCliente.get();
        //Retornamos el cliente en formato DTO
        return new DetalleClienteDTO(cliente.getCodigoCliente(), cliente.getNombre(),
                cliente.getFotoPerfil(), cliente.getNickname(), cliente.getEmail(),
                cliente.getCiudadResidencia());
    }


    @Override
    public void eliminarCuenta(String idCuenta) throws Exception {
        //Buscamos el cliente que se quiere eliminar
        Optional<Cliente> optionalCliente = clienteRepo.findById( idCuenta );
        //Si no se encontró el cliente, lanzamos una excepción
        if(optionalCliente.isEmpty()) {
            throw new Exception("No se encontró el cliente a eliminar");
        }
        //Obtenemos el cliente que se quiere eliminar y le asignamos el estado inactivo
        Cliente cliente = optionalCliente.get();
        cliente.setEstadoRegistro(EstadoRegistro.INACTIVO);
        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro
        // sino que actualiza el que ya existe
        clienteRepo.save(cliente);
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }
}