package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderadores")
@RequiredArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;
    private final NegocioServicio negocioServicio;

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>>
    actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception {
        moderadorServicio.actualizarModerador(actualizarModeradorDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Cliente actualizado correctamente"));
    }

    //Acciones que puede realizar un moderador respecto a los negocios

    @PutMapping("/rechazar-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    rechazarNegocio(@PathVariable String idNegocio) throws Exception {
        negocioServicio.rechazarNegocio(idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio rechazado con éxito"));
    }

    @GetMapping("/listar-negocios-estado/{estadoNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    filtrarPorEstado(@PathVariable EstadoNegocio estadoNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.filtrarPorEstado(estadoNegocio)));
    }


}
