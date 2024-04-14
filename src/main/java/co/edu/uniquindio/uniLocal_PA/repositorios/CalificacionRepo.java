package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ItemNegocioDTO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepo extends MongoRepository<Calificacion, String> {
    @Aggregation({"{ $match: { codigoNegocio: ?0 } }", "{ $lookup: { from: 'negocios', localField: " +
            "'codigoNegocio', foreignField: '_id', as: 'negocio' } }", "{ $unwind: '$negocio' }", "{ " +
            "$project: { fecha: '$fecha', valoracion: '$valoracion', mensaje: '$mensaje', " +
            "nombreNegocio: '$negocio.nombre', ubicacionNegocio: '$negocio.ubicacion' } }" })
    List<ItemNegocioDTO> listarCalificacionesNegocio(String codigoNegocio);
}
