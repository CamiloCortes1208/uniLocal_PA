package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.EventoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoControlador {

    private final EventoServicio eventoServicio;

    @PostMapping("/eventos/agregar-evento")
    public ResponseEntity<MensajeDTO<String>>
    agregarEvento(@Valid @RequestBody AgregarEventoDTO agregarEventoDTO) throws Exception {
        eventoServicio.agregarEvento(agregarEventoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Evento creado correctamente"));
    }

    @PutMapping("/eventos/actualizar-evento")
    public ResponseEntity<MensajeDTO<String>>
    actualizarEvento(@Valid @RequestBody ActualizarEventoDTO actualizarEventoDTO) throws Exception {
        eventoServicio.actualizarEvento(actualizarEventoDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Evento actualizado correctamente"));
    }

    @PutMapping("/eventos/terminar-evento/{codigoEvento}")
    public ResponseEntity<MensajeDTO<String>>
    terminarEvento(@PathVariable String codigoEvento) throws ResourceNotFoundException {
        eventoServicio.terminarEvento(codigoEvento);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Evento terminado correctamente"));
    }

    @GetMapping("/eventos/listar-eventos-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemEventoDTO>>>
    listarEventosNegocio(@PathVariable String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                eventoServicio.listarEventosNegocio(idNegocio) ));
    }
}
