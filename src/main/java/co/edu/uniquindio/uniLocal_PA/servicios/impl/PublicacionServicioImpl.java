package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.PublicacionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PublicacionServicioImpl implements PublicacionServicio {
    private final PublicacionRepo publicacionRepo;
    private final ClienteRepo clienteRepo;

    public PublicacionServicioImpl(PublicacionRepo publicacionRepo, ClienteRepo clienteRepo) {
        this.publicacionRepo = publicacionRepo;
        this.clienteRepo = clienteRepo;
    }


    @Override
    public void agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws Exception {
        Cliente cliente = obtenerClienteID(agregarPublicacionDTO.idCliente());

        Publicacion publicacion = new Publicacion();

        publicacion.setDescripcion(agregarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(agregarPublicacionDTO.rutaImagen());
        publicacion.setCodigoCliente(agregarPublicacionDTO.idCliente());
        publicacion.setFechaPublicacion(agregarPublicacionDTO.fechaPublicacion());

        Publicacion publicacionGuardada = publicacionRepo.save(publicacion);

        cliente.getListaPublicaciones().add(publicacionGuardada.getCodigoPublicacion());
        clienteRepo.save(cliente);

    }

    @Override
    public void actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception {
        Publicacion publicacion = obtenerPublicacionID(actualizarPublicacionDTO.idPublicacion());

        publicacion.setDescripcion(actualizarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(actualizarPublicacionDTO.rutaImagen());

        publicacionRepo.save(publicacion);
    }

    @Override
    public void eliminarPublicacion(String idPublicacion) throws ResourceNotFoundException {
        Publicacion publicacion = obtenerPublicacionID(idPublicacion);
        Cliente cliente = obtenerClienteID(publicacion.getCodigoCliente());

        cliente.getListaPublicaciones().remove(publicacion.getCodigoPublicacion());

        publicacionRepo.delete(publicacion);

    }
    private Cliente obtenerClienteID(String idCliente) throws ResourceNotFoundException {

        Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);

        if (optionalCliente.isEmpty()){
            throw new ResourceNotFoundException(idCliente);
        }

        return optionalCliente.get();
    }
    private Publicacion obtenerPublicacionID(String idPublicacion) throws ResourceNotFoundException {

        Optional<Publicacion> optionalPublicacion = publicacionRepo.findById(idPublicacion);

        if (optionalPublicacion.isEmpty()){
            throw new ResourceNotFoundException(idPublicacion);
        }

        return optionalPublicacion.get();
    }
}
