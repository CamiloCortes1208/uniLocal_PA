package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;

import java.util.List;

public interface OpinionServicio {

    void comentarPublicacion();
    void responderOpinion();
    void eliminarOpinion();
    List<Opinion> listarOpinionesPublicacion();
    List<Opinion> listarRespuestasOpinion();



}
