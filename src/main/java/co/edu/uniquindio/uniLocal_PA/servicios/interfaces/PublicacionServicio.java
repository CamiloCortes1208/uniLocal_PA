package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.publicacionDTO.AgregarPublicacionDTO;

public interface PublicacionServicio {
    void agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws Exception;
    void actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception;
    void eliminarPublicacion(String idPublicacion);
}
