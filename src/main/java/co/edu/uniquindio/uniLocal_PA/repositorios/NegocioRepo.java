package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ItemNegocioDTO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {

    List<Negocio> findAllByCategoriaNegocio(String categoria);

    List<Negocio> findAllByEstadoNegocio(EstadoNegocio estadoNegocio);

    List<Negocio> findAllByNombre(String nombre);

    List<Negocio> findAllByNombreLikeIgnoreCase(String nombre);

    @Aggregation({"{ $match: { codigoCliente: ?0 } }", "{ $lookup: { from: 'clientes', localField: " +
            "'codigoCliente', foreignField: '_id', as: 'cliente' } }", "{ $unwind: '$cliente' }", "{ " +
            "$project: { nombre: '$nombre', descripcion: '$descripcion'," +
            "categoriaNegocio: '$categoriaNegocio', ubicacion: '$ubicacion', " +
            "nombrePropietario: '$cliente.nombre', correoPropietario: '$cliente.email' } }" })
    List<ItemNegocioDTO> listarNegociosCliente(String codigoCliente);

 }
