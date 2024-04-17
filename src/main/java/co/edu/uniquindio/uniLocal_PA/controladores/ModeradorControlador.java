package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.AgregarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.DetalleRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.ItemRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.RevisionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/moderadores")
@RequiredArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;
    private final NegocioServicio negocioServicio;
    private final RevisionServicio revisionServicio;

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>>
    actualizarModerador(@Valid @RequestBody ActualizarModeradorDTO actualizarModeradorDTO) throws Exception {
        moderadorServicio.actualizarModerador(actualizarModeradorDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Cliente actualizado correctamente"));
    }

    //Acciones que puede realizar un moderador respecto a los negocios

    @GetMapping("/listar-negocios-estado/{estadoNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    filtrarPorEstado(@PathVariable EstadoNegocio estadoNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.filtrarPorEstado(estadoNegocio)));
    }

    //Acciones que realiza un moderador respecto a las revisiones de los negocios

    @PostMapping("/agregar-revision")
    public ResponseEntity<MensajeDTO<String>>
    agregarRevision(@Valid @RequestBody AgregarRevisionDTO agregarRevisionDTO) throws Exception {
        revisionServicio.agregarRevision(agregarRevisionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Revisión registrada correctamente"));
    }

    @GetMapping("/obtener-revision/{codigoRevision}")
    public ResponseEntity<MensajeDTO<DetalleRevisionDTO>>
    obtenerRevision(@PathVariable String codigoRevision) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                revisionServicio.obtenerRevision(codigoRevision)));
    }

    @GetMapping("/listar-revisiones-moderador/{codigoModerador}")
    public ResponseEntity<MensajeDTO<List<ItemRevisionDTO>>>
    listarRevisionModerador(@PathVariable String codigoModerador) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                revisionServicio.listarRevisionModerador(codigoModerador)));
    }

    @GetMapping("/listar-revisiones-negocio/{codigoNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemRevisionDTO>>>
    listarRevisionNegocio(@PathVariable String codigoNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                revisionServicio.listarRevisionNegocio(codigoNegocio)));
    }

}
