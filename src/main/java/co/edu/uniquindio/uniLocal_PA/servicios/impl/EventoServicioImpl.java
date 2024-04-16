package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.EventoRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.EventoServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventoServicioImpl implements EventoServicio {
    private final EventoRepo eventoRepo;

    public EventoServicioImpl(EventoRepo eventoRepo, NegocioRepo negocioRepo) {
        this.eventoRepo = eventoRepo;
    }

    @Override
    public String agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception {

        Evento evento = new Evento();

        evento.setNombre(agregarEventoDTO.nombre());
        evento.setDescripcion(agregarEventoDTO.descripcion());
        evento.setTipoEvento(agregarEventoDTO.tipoEvento());
        evento.setDiasDisponible(agregarEventoDTO.horario());
        evento.setEstadoEvento(EstadoEvento.EN_CURSO);
        evento.setCodigoNegocio(agregarEventoDTO.idNegocio());

        Evento eventoGuardado = eventoRepo.save(evento);
        return eventoGuardado.getCodigoEvento();
    }

    @Override
    public void actualizarEvento(ActualizarEventoDTO actualizarEventoDTO) throws Exception {
        Evento evento = obtenerEventoID(actualizarEventoDTO.codigoEvento());

        evento.setNombre(actualizarEventoDTO.nombre());
        evento.setDescripcion(actualizarEventoDTO.descripcion());
        evento.setTipoEvento(actualizarEventoDTO.tipoEvento());
        evento.setDiasDisponible(actualizarEventoDTO.horario());

        eventoRepo.save(evento);
    }

    @Override
    public void terminarEvento(String codigoEvento) throws ResourceNotFoundException {
        Evento evento = obtenerEventoID(codigoEvento);

        evento.setEstadoEvento(EstadoEvento.FINALIZADO);

        eventoRepo.save(evento);
    }

    @Override
    public List<ItemEventoDTO> listarEventosNegocio(String idNegocio) throws Exception {
        return null;
    }

    private Evento obtenerEventoID(String idEvento) throws ResourceNotFoundException {

        Optional<Evento> optionalEvento = eventoRepo.findById(idEvento);

        if (optionalEvento.isEmpty()){
            throw new ResourceNotFoundException(idEvento);
        }

        return optionalEvento.get();
    }
    private boolean existeEvento(String idEvento){
        return eventoRepo.findById(idEvento).isPresent();
    }
}
