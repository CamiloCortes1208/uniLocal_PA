package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.OpinionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes/opiniones")
@RequiredArgsConstructor
public class OpinionControlador {
    private final OpinionServicio opinionServicio;

    @PostMapping("/agregar-opinion-publicacion")
    public ResponseEntity<MensajeDTO<String>>
    opinarPublicacion(@Valid @RequestBody OpinarPublicacionDTO opinarPublicacionDTO) throws Exception {
        opinionServicio.opinarPublicacion(opinarPublicacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Opinión agregada correctamente"));
    }

    @GetMapping("listar-opiniones-publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO<List<ItemOpinionDTO>>>
    listarOpinionesPublicacion(@PathVariable String idPublicacion) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                opinionServicio.listarOpinionesPublicacion(idPublicacion) ));
    }

    @PostMapping("reaccionar-opinion")
    public ResponseEntity<MensajeDTO<String>>
    reaccionarOpinion(@Valid @RequestBody ReaccionarOpinionDTO reaccionarOpinionDTO) throws Exception {
        opinionServicio.reaccionarOpinion(reaccionarOpinionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Reacción agregada correctamente"));
    }

    @GetMapping("/listar-opiniones-cliente/{idCliente}")
    public ResponseEntity<MensajeDTO<List<ItemOpinionDTO>>>
    listarOpinionesCliente(@PathVariable String idCliente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>( false,
                opinionServicio.listarOpinionesCliente(idCliente)));
    }
}
