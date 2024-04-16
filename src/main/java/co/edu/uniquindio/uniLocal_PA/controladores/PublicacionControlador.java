package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.PublicacionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicaciones")
@RequiredArgsConstructor
public class PublicacionControlador {
    private final PublicacionServicio publicacionServicio;

    @PostMapping("/agregar-publicacion")
    public ResponseEntity<MensajeDTO<String>>
    agregarPublicacion(@Valid @RequestBody AgregarPublicacionDTO agregarPublicacionDTO) throws Exception {
        publicacionServicio.agregarPublicacion(agregarPublicacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Publicación creada correctamente"));
    }

    @GetMapping("/obtener-publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO<ItemPublicacionDTO>>
    obtenerPublicacion(@PathVariable String idPublicacion) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                publicacionServicio.obtenerPublicacion(idPublicacion)));
    }

    @PutMapping("/actualizar-publicacion")
    public ResponseEntity<MensajeDTO<String>>
    actualizarPublicacion(@Valid @RequestBody ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception {
        publicacionServicio.actualizarPublicacion(actualizarPublicacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Publicación editada correctamente"));
    }

    @PutMapping("/eliminar-publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO<String>>
    eliminarPublicacion(@PathVariable String idPublicacion) throws Exception {
        publicacionServicio.eliminarPublicacion(idPublicacion);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Publicación eliminada correctamente"));

    }

}
