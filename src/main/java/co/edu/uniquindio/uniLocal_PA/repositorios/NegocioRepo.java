package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {

    List<Negocio> findAllByCategoriaNegocio(CategoriaNegocio categoriaNegocio);

    List<Negocio> findAllByEstadoNegocio(EstadoNegocio estadoNegocio);

    List<Negocio> findAllByNombre(String nombre);

    List<Negocio> findAllByNombreLikeIgnoreCase(String nombre);

    List<ItemNegocioDTO> findAllByCodigoCliente(String codigoCliente);

}
