package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ItemOpinionDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepo extends MongoRepository<Opinion,String> {
    List<ItemOpinionDTO> findAllByCodigoCliente(String idCliente);
    List<ItemOpinionDTO> findAllByCodigoPublicacion(String idPublicacion);
}
