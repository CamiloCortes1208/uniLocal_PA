package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import org.apache.catalina.Pipeline;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {

    List<ItemNegocioDTO> findAllByCategoriaNegocioAndEstadoRegistro(CategoriaNegocio categoriaNegocio, EstadoRegistro estadoRegistro);
    List<ItemNegocioDTO> findAllByNombreLikeIgnoreCaseAndEstadoRegistro(String nombre, EstadoRegistro estadoRegistro);
    List<ItemNegocioDTO> findAllByCodigoClienteAndEstadoRegistro(String codigoCliente, EstadoRegistro estadoRegistro);
    List<ItemNegocioDTO> findAllByEstadoNegocioAndEstadoRegistro(EstadoNegocio estadoNegocio, EstadoRegistro estadoRegistro);
    @Query("{ $and: [{ 'ubicacion.latitud' : {$gte:?0}},{ 'ubicacion.latitud' : {$lte: ?1}},{ 'ubicacion.longitud' :  {$gte: ?2}}, { 'ubicacion.longitud' :  {$lte: ?3}}, { 'estadoRegistro' : {$eq: ?4}}]}")
    List<ItemNegocioDTO> listarNegociosPorUbicacion(double latitudMin, double latitudMax, double longitudMin, double longitudMax, EstadoRegistro estadoRegistro);


    /*@Aggregation(pipeline = {
            "{ $match: { 'ubicacion.latitud' : { $gte: ?0, $lte: ?1 }, 'ubicacion.longitud' : { $gte: ?2, $lte: ?3 }, 'estadoRegistro' : ?4 } }",
            "{ $group: { _id: null, avgVisitas: { $avg: '$visitas' } } }",
            "{ $lookup: { from: 'negocios', let: { avgVisitas: '$avgVisitas' }, pipeline: [ " +
                    "{ $match: { $expr: { $and: [ " +
                    "{ $gte: ['$ubicacion.latitud', ?0] }, { $lte: ['$ubicacion.latitud', ?1] }, " +
                    "{ $gte: ['$ubicacion.longitud', ?2] }, { $lte: ['$ubicacion.longitud', ?3] }, " +
                    "{ $eq: ['$estadoRegistro', ?4] }, " +
                    "{ $gt: ['$visitas', '$$avgVisitas'] } " +
                    "] } } } " +
                    "], as: 'filteredNegocios' } }",
            "{ $unwind: '$filteredNegocios' }",
            "{ $replaceRoot: { newRoot: '$filteredNegocios' } }"
    })*/
    @Aggregation(pipeline = {
            "{ $match: { 'ubicacion.latitud' : { $gte: ?0, $lte: ?1 }, 'ubicacion.longitud' : { $gte: ?2, $lte: ?3 }, 'estadoRegistro' : ?4 } }",
            "{ $group: { _id: null, avgVisitas: { $avg: '$visitas' } } }",
            "{ $lookup: { from: 'negocios', let: { avgVisitas: '$avgVisitas' }, pipeline: [ " +
                    "{ $match: { $expr: { $and: [ " +
                    "{ $gte: ['$ubicacion.latitud', ?0] }, { $lte: ['$ubicacion.latitud', ?1] }, " +
                    "{ $gte: ['$ubicacion.longitud', ?2] }, { $lte: ['$ubicacion.longitud', ?3] }, " +
                    "{ $eq: ['$estadoRegistro', ?4] }, " +
                    "{ $gt: ['$visitas', '$$avgVisitas'] } " +
                    "] } } } " +
                    "], as: 'filteredNegocios' } }",
            "{ $unwind: '$filteredNegocios' }",
            "{ $replaceRoot: { newRoot: '$filteredNegocios' } }",
            "{ $project: { _id: '$codigoNegocio', codigoCliente: 1, nombre: 1, descripcion: 1, categoriaNegocio: 1, estadoNegocio: 1, ubicacion: 1, visitas: 1, listaTelefonos: 1, listaRutasImagenes: 1, listaHorarios: 1, estadoRegistro: 1 } }"
    })
    List<ItemNegocioDTO> listarNegociosRecomendadosZona(double latitudMin, double latitudMax, double longitudMin, double longitudMax, EstadoRegistro estadoRegistro);

    List<ItemNegocioDTO> findAllByCodigoClienteAndEstadoRegistroAndEstadoNegocio(String codigoCliente, EstadoRegistro estadoRegistro, EstadoNegocio estadoNegocio);

}
