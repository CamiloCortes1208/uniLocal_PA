package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ResponderCalificacionDTO;

import java.util.List;

public interface CalificacionServicio {
    String agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception;

    void actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception;

    List<ItemCalificacionDTO> listarCalificacionesNegocio(String idNegocio) throws Exception;

    void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception;

    float obtenerCalificacionPromedioNegocio(String codigoNegocio);
}
