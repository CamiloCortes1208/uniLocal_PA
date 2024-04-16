package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/negocios")
@RequiredArgsConstructor
public class NegocioControlador {
    private final NegocioServicio negocioServicio;

    @PostMapping("/agregar-negocio")
    public ResponseEntity<MensajeDTO<String>>
    agregarNegocio(@Valid @RequestBody AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        negocioServicio.agregarNegocio(agregarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio creado correctamente"));
    }

    @GetMapping("/obtener-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<DetalleNegocioDTO>>
    obtenerNegocio(@PathVariable String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.obtenerNegocio(idNegocio)));
    }

    @PutMapping("/actualizar-negocio")
    public ResponseEntity<MensajeDTO<String>>
    actualizarNegocio(@Valid @RequestBody ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {
        negocioServicio.actualizarNegocio(actualizarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio actualizado correctamente"));
    }

    @PutMapping("/eliminar-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    eliminarNegocio(@PathVariable String idNegocio) throws Exception {
        negocioServicio.eliminarNegocio(idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio eliminado correctamente"));
    }

    @GetMapping("/existe-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<Boolean>>
    existeNegocio(@PathVariable String idNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.existeNegocio(idNegocio)));
    }

    @PutMapping("/rechazar-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    rechazarNegocio(@PathVariable String idNegocio) throws Exception {
        negocioServicio.rechazarNegocio(idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio rechazado con éxito"));
    }

    @GetMapping("/listar-negocios-categoria/{categoriaNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    buscarNegociosPorCategoria(@PathVariable CategoriaNegocio categoriaNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.buscarNegociosPorCategoria(categoriaNegocio)));
    }

    @GetMapping("/listar-negocios-nombre/{nombre}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    buscarNegociosPorNombreSimilar(@PathVariable String nombre) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.buscarNegociosPorNombreSimilar(nombre)));
    }

    @GetMapping("/listar-negocios-estado/{estadoNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    filtrarPorEstado(@PathVariable EstadoNegocio estadoNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.filtrarPorEstado(estadoNegocio)));
    }

    @GetMapping("/listar-negocios-propietario/{idPropietario}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    listarNegociosPropietario(@PathVariable String idPropietario) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.listarNegociosPropietario(idPropietario)));
    }

    @PutMapping("/cambiar-estado-negocio/{idNegocio}/{estadoNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    cambiarEstado(@PathVariable String idNegocio, @PathVariable EstadoNegocio estadoNegocio) throws Exception {
        negocioServicio.cambiarEstado(idNegocio, estadoNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Estado de negocio cambiado correctamente"));
    }

    @PutMapping("/reactivar-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    reactivarNegocio(@PathVariable String idNegocio) throws Exception {
        negocioServicio.reactivarNegocio(idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio re activado correctamente"));
    }

    @PutMapping("/aprobar-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    aprobarNegocio(@PathVariable String idNegocio) throws Exception {
        negocioServicio.aprobarNegocio(idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio aprobado correctamente"));
    }
}
