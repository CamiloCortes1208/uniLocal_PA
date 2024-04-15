package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.eventoDTO.ItemEventoDTO;

import java.util.List;

public interface EventoServicio {
    void agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception;
    void actualizarEvento(ActualizarEventoDTO actualizarEventoDTO) throws Exception;
    void terminarEvento(String codigoEvento) throws ResourceNotFoundException;
    void elimninarEvento(String codigoEvento) throws ResourceNotFoundException;
    List<ItemEventoDTO> listarEventosNegocio(String idNegocio) throws Exception;
}
