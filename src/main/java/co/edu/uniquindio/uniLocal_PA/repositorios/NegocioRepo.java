package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.DetalleNegocioDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {

    List<Negocio> findAllByCategoria(String categoria);

    List<Negocio> findAllByEstadoNegocio(EstadoNegocio estadoNegocio);
 }
