package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Evento;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.AgregarEventoDTO;

public interface EventoServicio {
    void agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception;
    void eliminarEvento(Evento evento);
}
