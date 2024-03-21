package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion;
import co.edu.uniquindio.uniLocal_PA.repositorios.OpinionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ComentarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ResponderOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.OpinionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OpinionServicioImpl implements OpinionServicio {

    private final OpinionRepo opinionRepo;

    public OpinionServicioImpl(OpinionRepo opinionRepo) {
        this.opinionRepo = opinionRepo;
    }


    @Override
    public String comentarPublicacion(String idPublicacion, ComentarPublicacionDTO comentarPublicacionDTO) throws Exception {
        return "a";
    }

    @Override
    public void responderOpinion(String idOpinion, ResponderOpinionDTO responderOpinionDTO) throws Exception {


        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if(optionalOpinion.isEmpty()){
            throw new Exception("No existe una opinión con el id "+idOpinion);
        }

        //Se obtiene la opinión

        Opinion opinion = optionalOpinion.get();

        //Se crea la respuesta
        Opinion respuesta = new Opinion();
        respuesta.setMensaje( responderOpinionDTO.respuesta() );

        //Se agrega la respuesta
        opinion.getListaRespuestas().add( respuesta );

        //Se actualiza la información de la opinión en el repositorio
        opinionRepo.save(opinion);

    }

    @Override
    public void eliminarOpinion(String idOpinion) throws Exception {

        //Se busca la opinión a eliminar
        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if(optionalOpinion.isEmpty()){
            throw new Exception("No existe una opinión con el id "+idOpinion);
        }

        //Se obtiene la opinión a eliminar
        Opinion opinion = optionalOpinion.get();

        //Se elimina la opinión de la base de datos
        opinionRepo.delete(opinion);

    }

    @Override
    public List<Opinion> listarOpinionesPublicacion(String idPublicacion) {
        return null;
    }

    @Override
    public List<Opinion> listarRespuestasOpinion(String idOpinion) {
        return null;
    }

    @Override
    public List<Opinion> listarOpinionesCliente(String idCliente) throws Exception {
        return null;
    }
}
