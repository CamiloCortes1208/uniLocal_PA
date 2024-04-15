package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.EventoRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.EventoServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventoServicioImpl implements EventoServicio {
    private final EventoRepo eventoRepo;
    private final NegocioRepo negocioRepo;

    public EventoServicioImpl(EventoRepo eventoRepo, NegocioRepo negocioRepo) {
        this.eventoRepo = eventoRepo;
        this.negocioRepo = negocioRepo;
    }

    @Override
    public void agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception {
        Negocio negocio = obtenerNegocioID(agregarEventoDTO.idNegocio());

        Evento evento = new Evento();

        evento.setNombre(agregarEventoDTO.nombre());
        evento.setDescripcion(agregarEventoDTO.descripcion());
        evento.setTipoEvento(agregarEventoDTO.tipoEvento());
        evento.setDiasDisponible(agregarEventoDTO.horario());
        evento.setEstadoEvento(EstadoEvento.EN_CURSO);
        evento.setCodigoNegocio(agregarEventoDTO.idNegocio());

        Evento eventoGuardado = eventoRepo.save(evento);

        negocio.getListaEventos().add(eventoGuardado.getCodigoEvento());
        negocioRepo.save(negocio);
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
        Negocio negocio = obtenerNegocioID(idNegocio);

        List<ItemEventoDTO> items = new ArrayList<>();
        for (String idEvento : negocio.getListaEventos()){
            Evento evento = obtenerEventoID(idEvento);
            items.add(new ItemEventoDTO(evento.getCodigoEvento(), evento.getCodigoNegocio(), evento.getNombre(),
                    evento.getDescripcion(), evento.getTipoEvento(), evento.getDiasDisponible(), evento.getEstadoEvento()));
        }
        return items;
    }


    private Negocio obtenerNegocioID(String idNegocio) throws ResourceNotFoundException {

        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if (optionalNegocio.isEmpty()){
            throw new ResourceNotFoundException(idNegocio);
        }

        return optionalNegocio.get();
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
