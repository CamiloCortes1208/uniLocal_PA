package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ComentarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ResponderOpinionDTO;

import java.util.List;

public interface OpinionServicio {

    void comentarPublicacion(ComentarPublicacionDTO comentarPublicacionDTO) throws Exception;
    void responderOpinion(ResponderOpinionDTO responderOpinionDTO) throws Exception;
    void eliminarOpinion(String idOpinion);
    List<Opinion> listarOpinionesPublicacion(String idPublicacion);
    List<Opinion> listarRespuestasOpinion(String idOpinion);
    List<Opinion> listarOpinionesCliente(String idCliente) throws Exception;
}
