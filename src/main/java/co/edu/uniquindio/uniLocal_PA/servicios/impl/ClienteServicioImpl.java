package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {
    private final ClienteRepo clienteRepo;
    NegocioServicio negocioServicio;
    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {

        if( existeEmail(registroClienteDTO.email()) ){
            throw new Exception("El correo ya se encuentra registrado");
        }

        if( existeNickname(registroClienteDTO.nickname()) ){
            throw new Exception("El nickname ya se encuentra registrado por otro usuario");
        }

        //Se crea el objeto Cliente
        Cliente cliente = new Cliente();

        //Se le asignan sus campos
        cliente.setNombre( registroClienteDTO.nombre() );
        cliente.setNickname( registroClienteDTO.nickname() );
        cliente.setCiudadResidencia( registroClienteDTO.ciudadResidencia() );
        cliente.setFotoPerfil( registroClienteDTO.fotoPerfil() );
        cliente.setEmail( registroClienteDTO.email() );
        cliente.setEstadoRegistro(EstadoRegistro.ACTIVO);

        //Para la contraseña
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( registroClienteDTO.password() );
        cliente.setPassword( passwordEncriptada );

        //Se guarda en la base de datos y obtenemos el objeto registrado
        Cliente clienteGuardado = clienteRepo.save(cliente);

        //Retornamos el id (código) del cliente registrado
        return clienteGuardado.getCodigoCliente();
    }

    @Override
    public String agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception {

        //Se obtiene el cliente al cual se le va a agregar el negocio favorito
        Cliente cliente = obtenerClienteID(idCliente);

        /*
        Se arroja una excepción en caso de que no exista el negocio que se quiere
        agregar a los favoritos del cliente
         */
        if(!negocioServicio.existeNegocio(idNegocio)){
            throw new ResourceNotFoundException(idNegocio);
        }

        //En caso de ya estar en la lista de favoritos, se elimina
        if(cliente.getListaNegociosFavoritos().contains(idNegocio)) {
            cliente.getListaNegociosFavoritos().remove(idNegocio);
        }
        //En caso contrario, se quita de la lista
        else{
            cliente.getListaNegociosFavoritos().add(idNegocio);
        }

        //Se actualiza la información del cliente en el repositorio
        clienteRepo.save(cliente);

        //Se retorna el código del negocio para verificar en los tests
        return idNegocio;

    }

    @Override
    public void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception {

        if(existeEmail(actualizarClienteDTO.email())){
            throw new Exception("El email ya está en uso");
        }

        //Obtenemos el cliente que se quiere actualizar y le asignamos los nuevos valores (el
        //nickname no se puede cambiar)
        Cliente cliente = obtenerClienteID(actualizarClienteDTO.id());
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

        Cliente cliente = obtenerClienteID(idCliente);

        if(cliente.getEstadoRegistro().equals(EstadoRegistro.INACTIVO)){
            throw new Exception("El cliente con el id "+idCliente+" tiene su cuenta inactiva");
        }

        //Retornamos el cliente en formato DTO
        return new DetalleClienteDTO(cliente.getCodigoCliente(), cliente.getNombre(),
                cliente.getFotoPerfil(), cliente.getNickname(), cliente.getEmail(),
                cliente.getCiudadResidencia(),cliente.getListaNegociosFavoritos());
    }

    @Override
    public boolean existeCliente(String idCliente) {
        return clienteRepo.findById(idCliente).isPresent();
    }

    @Override
    public List<ItemClienteDTO> listarClientes() {

        //Obtenemos todos los clientes de la base de datos
        List<Cliente> clientes = clienteRepo.findAll();

        //Creamos una lista de DTOs de clientes
        List<ItemClienteDTO> listaItemClienteDTO = new ArrayList<>();

        //Recorremos la lista de clientes y por cada uno creamos un DTO y lo agregamos a la lista
        for (Cliente cliente : clientes) {
            //Se verifica que la cuenta del cliente esté activa, para listarlo
            if(cliente.getEstadoRegistro().equals(EstadoRegistro.ACTIVO)){
                listaItemClienteDTO.add(new ItemClienteDTO(cliente.getCodigoCliente(),
                        cliente.getNombre(), cliente.getFotoPerfil(), cliente.getNickname(),
                        cliente.getEmail(), cliente.getCiudadResidencia(),
                        cliente.getListaNegociosFavoritos()));
            }
        }
        return listaItemClienteDTO;
    }


    @Override
    public void eliminarCliente(String idCuenta) throws Exception {

        Cliente cliente = obtenerClienteID(idCuenta);

        cliente.setEstadoRegistro(EstadoRegistro.INACTIVO);

        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro
        // sino que actualiza el que ya existe
        clienteRepo.save(cliente);
    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }


    //Metodos para verificar existencia de datos
    public Cliente obtenerClienteID(String idCliente) throws ResourceNotFoundException {
        Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);

        if (optionalCliente.isEmpty()){
            throw new ResourceNotFoundException(idCliente);
        }

        return optionalCliente.get();
    }


    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }

    private boolean existeNickname(String nickname) {
        return clienteRepo.findByNickname(nickname).isPresent();
    }

}