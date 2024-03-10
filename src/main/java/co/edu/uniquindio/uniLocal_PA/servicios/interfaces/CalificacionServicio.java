package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ResponderCalificacionDTO;

import java.util.List;

public interface CalificacionServicio {
    void agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception;

    void actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception;

    List<Calificacion> listarCalificacionesNegocio();

    void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception;
}
