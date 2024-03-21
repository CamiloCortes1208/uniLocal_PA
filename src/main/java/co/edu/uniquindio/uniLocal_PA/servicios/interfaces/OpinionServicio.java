package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ComentarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ResponderOpinionDTO;

import java.util.List;

public interface OpinionServicio {

    String comentarPublicacion(String idPublicacion, ComentarPublicacionDTO comentarPublicacionDTO) throws Exception;
    void responderOpinion(String idOpinion, ResponderOpinionDTO responderOpinionDTO) throws Exception;
    void eliminarOpinion(String idOpinion) throws Exception;
    List<Opinion> listarOpinionesPublicacion(String idPublicacion);
    List<Opinion> listarRespuestasOpinion(String idOpinion);
    List<Opinion> listarOpinionesCliente(String idCliente) throws Exception;
}
