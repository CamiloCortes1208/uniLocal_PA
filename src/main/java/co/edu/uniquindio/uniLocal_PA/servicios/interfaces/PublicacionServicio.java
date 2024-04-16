package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ItemPublicacionDTO;

public interface PublicacionServicio {
    String agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws Exception;
    ItemPublicacionDTO obtenerPublicacion(String idPublicacion) throws ResourceNotFoundException;
    void actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception;
    void eliminarPublicacion(String idPublicacion) throws Exception;
    boolean existePublicacion(String idPublicacion);
}
