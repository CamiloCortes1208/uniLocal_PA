package co.edu.uniquindio.uniLocal_PA.repositorios;

import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoEvento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepo extends MongoRepository<Evento, String> {
    List<ItemEventoDTO> findAllByCodigoNegocio(String codigoNegocio);
    List<ItemEventoDTO> findAllByEstadoEvento(EstadoEvento estadoEvento);
}
