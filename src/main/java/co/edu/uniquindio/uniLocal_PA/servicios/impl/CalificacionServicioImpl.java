package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.CalificacionRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.CalificacionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CalificacionServicioImpl implements CalificacionServicio {
    private final CalificacionRepo calificacionRepo;
    private final NegocioRepo negocioRepo;
    private final ClienteRepo clienteRepo;

    public CalificacionServicioImpl(CalificacionRepo calificacionRepo, NegocioRepo negocioRepo, ClienteRepo clienteRepo) {
        this.calificacionRepo = calificacionRepo;
        this.negocioRepo = negocioRepo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception {

        //Se crea la calificación
        Calificacion calificacion = new Calificacion();

        //Se asignan sus datos
        calificacion.setCodigoCliente( agregarCalificacionDTO.codigoCliente() );
        calificacion.setCodigoNegocio( agregarCalificacionDTO.codigoNegocio() );
        calificacion.setFecha( agregarCalificacionDTO.fecha() );
        calificacion.setValoracion( agregarCalificacionDTO.valoracion() );
        calificacion.setMensaje( agregarCalificacionDTO.mensaje() );

        //Se agrega a la base de datos
        Calificacion calificacionGuardada = calificacionRepo.save(calificacion);

        //Se obtiene el codigo de la calificación para verificar su funcionamiento
        return calificacionGuardada.getCodigoCalificacion();
    }

    @Override
    public void actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception {

        Calificacion calificacion = obtenerCalificacionID(actualizarCalificacionDTO.idCalificacion());

        //Se actualizan la valoración y el mensaje
        calificacion.setValoracion( actualizarCalificacionDTO.valoracion() );
        calificacion.setMensaje( actualizarCalificacionDTO.mensaje() );

        //Se actualiza la calificación en la base de datos
        calificacionRepo.save(calificacion);
    }

    @Override
    public List<ItemCalificacionDTO> listarCalificacionesNegocio(String idNegocio) throws ResourceNotFoundException {
        return calificacionRepo.listarCalificacionesNegocio(idNegocio);
    }

    @Override
    public void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {
        Calificacion calificacion = obtenerCalificacionID(responderCalificacionDTO.idCalificacion());

        calificacion.setRespuesta(responderCalificacionDTO.respuesta());

        calificacionRepo.save(calificacion);
    }

    @Override
    public float obtenerCalificacionPromedioNegocio(String codigoNegocio) {
        return calificacionRepo.obtenerCalificacionPromedio(codigoNegocio);
    }

    //Metodos para verificar la existencia de un recurso
    private Calificacion obtenerCalificacionID(String idCalificacion) throws ResourceNotFoundException {

        Optional<Calificacion> optionalCalificacion = calificacionRepo.findById(idCalificacion);

        if (optionalCalificacion.isEmpty()){
            throw new ResourceNotFoundException(idCalificacion);
        }

        return optionalCalificacion.get();
    }

}
