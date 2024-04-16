package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.CalificacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

    @PostMapping("/agregar-Calificacion")
    public ResponseEntity<MensajeDTO<String>>
    agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception{
        calificacionServicio.agregarCalificacion(agregarCalificacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Calificación agregada correctamente"));
    }

    @PutMapping("/actualizar-calificacion")
    public ResponseEntity<MensajeDTO<String>>
    actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception {
        calificacionServicio.actualizarCalificacion(actualizarCalificacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Calificación actualizada correctamente"));
    }

    @GetMapping("/listar-calificaciones-negocio")
    public ResponseEntity<MensajeDTO<List<ItemCalificacionDTO>>>
    listarCalificacionesNegocio(String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                calificacionServicio.listarCalificacionesNegocio(idNegocio)));
    }

    @PostMapping("/responder-calificacion")
    public ResponseEntity<MensajeDTO<String>>
    responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {
        calificacionServicio.responderCalificacion(responderCalificacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Respuesta agregada correctamente"));
    }

    @GetMapping("/obtener-calificacion-promedio")
    public ResponseEntity<MensajeDTO<Float>>
    obtenerCalificacionPromedioNegocio(String codigoNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                calificacionServicio.obtenerCalificacionPromedioNegocio(codigoNegocio)));
    }

}
