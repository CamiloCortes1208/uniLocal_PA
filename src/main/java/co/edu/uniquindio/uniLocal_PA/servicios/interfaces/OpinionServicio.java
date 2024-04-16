package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.OpinarPublicacionDTO;

import java.util.List;

public interface OpinionServicio {
    String opinarPublicacion(OpinarPublicacionDTO opinarPublicacionDTO) throws Exception;
    List<ItemOpinionDTO> listarOpinionesPublicacion(String idPublicacion) throws ResourceNotFoundException;
    void reaccionarOpinion(String idOpinion, String idCliente) throws Exception;
    List<ItemOpinionDTO> listarOpinionesCliente(String idCliente) throws Exception;
}
