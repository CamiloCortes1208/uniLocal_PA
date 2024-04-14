package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal_PA.repositorios.CalificacionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CalificacionServicioImpl implements CalificacionServicio {
    private final CalificacionRepo calificacionRepo;
    NegocioServicio negocioServicio;

    public CalificacionServicioImpl(CalificacionRepo calificacionRepo) {
        this.calificacionRepo = calificacionRepo;
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
        calificacionRepo.save(calificacion);

        //Se obtiene el codigo de la calificación para verificar su funcionamiento
        return calificacion.getCodigoCalificacion();
    }

    @Override
    public void actualizarCalificacion(String idCalificacion, ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception {

        Optional<Calificacion> optionalCalificacion = calificacionRepo.findById(idCalificacion);

        if(optionalCalificacion.isEmpty()){
            throw new Exception("No existe una calificación con el código "+ idCalificacion);
        }

        //Se obtiene la calificación a actualizar
        Calificacion calificacion = optionalCalificacion.get();

        //Se actualizan la valoración y el mensaje
        calificacion.setValoracion( actualizarCalificacionDTO.valoracion() );
        calificacion.setMensaje( actualizarCalificacionDTO.mensaje() );

        //Se actualiza la calificación en la base de datos
        calificacionRepo.save(calificacion);
    }

    @Override
    public List<ItemCalificacionDTO> listarCalificacionesNegocio(String idNegocio) {
        //return calificacionRepo.listarCalificacionesNegocio(idNegocio);
        return null;
    }

    @Override
    public void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {

    }

    @Override
    public float obtenerCalificacionPromedioNegocio(List<ItemCalificacionDTO> listaItemCalificacionDTO) {
        return 0;
    }
}
