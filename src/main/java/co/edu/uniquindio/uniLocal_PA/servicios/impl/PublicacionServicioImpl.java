package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.PublicacionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PublicacionServicioImpl implements PublicacionServicio {
    private final PublicacionRepo publicacionRepo;

    ClienteServicio clienteServicio;

    public PublicacionServicioImpl(PublicacionRepo publicacionRepo) {
        this.publicacionRepo = publicacionRepo;
    }

    @Override
    public String agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws Exception {

        Publicacion publicacion = new Publicacion();

        publicacion.setDescripcion(agregarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(agregarPublicacionDTO.rutaImagen());
        publicacion.setCodigoCliente(agregarPublicacionDTO.idCliente());
        publicacion.setFechaPublicacion(agregarPublicacionDTO.fechaPublicacion());

        Publicacion publicacionGuardada = publicacionRepo.save(publicacion);

        clienteServicio.agregarPublicacionCliente(agregarPublicacionDTO.idCliente());

        return publicacionGuardada.getCodigoPublicacion();

    }

    @Override
    public ItemPublicacionDTO obtenerPublicacion(String idPublicacion) throws ResourceNotFoundException {
        Publicacion publicacion = obtenerPublicacionID(idPublicacion);

        ItemPublicacionDTO itemPublicacionDTO = new ItemPublicacionDTO(
                publicacion.getCodigoPublicacion(),
                publicacion.getCodigoCliente(),
                publicacion.getDescripcion(),
                publicacion.getListaMeGustas(),
                publicacion.getRutaImagen(),
                publicacion.getListaOpiniones(),
                publicacion.getFechaPublicacion()
        );

        return itemPublicacionDTO;
    }

    @Override
    public void actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception {
        Publicacion publicacion = obtenerPublicacionID(actualizarPublicacionDTO.idPublicacion());

        publicacion.setDescripcion(actualizarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(actualizarPublicacionDTO.rutaImagen());

        publicacionRepo.save(publicacion);
    }

    @Override
    public void eliminarPublicacion(String idPublicacion) throws Exception {

        Publicacion publicacion = obtenerPublicacionID(idPublicacion);
        publicacion.setEstadoRegistro(EstadoRegistro.INACTIVO);

        publicacionRepo.save(publicacion);

    }

    private Publicacion obtenerPublicacionID(String idPublicacion) throws ResourceNotFoundException {

        Optional<Publicacion> optionalPublicacion = publicacionRepo.findById(idPublicacion);

        if (optionalPublicacion.isEmpty()){
            throw new ResourceNotFoundException(idPublicacion);
        }

        return optionalPublicacion.get();
    }
}
