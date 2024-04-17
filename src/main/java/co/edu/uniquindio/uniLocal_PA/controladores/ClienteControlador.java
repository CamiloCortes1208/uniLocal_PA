package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.DetalleClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;
    private final NegocioServicio negocioServicio;
    private final CalificacionServicio calificacionServicio;
    private final OpinionServicio opinionServicio;
    private final PublicacionServicio publicacionServicio;
    private final EventoServicio eventoServicio;

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>>
    editarPerfil(@Valid @RequestBody ActualizarClienteDTO actualizarClienteDTO) throws Exception {
        clienteServicio.editarPerfil(actualizarClienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Cliente actualizado correctamente"));
    }

    @PutMapping("/eliminar/{idCuenta}")
    public ResponseEntity<MensajeDTO<String>>
    eliminarCliente(@PathVariable String idCuenta) throws Exception {
        clienteServicio.eliminarCliente(idCuenta);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Cliente eliminado correctamente"));
    }

    @GetMapping("/obtener/{idCliente}")
    public ResponseEntity<MensajeDTO<DetalleClienteDTO>>
    obtenerCliente(@PathVariable String idCliente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clienteServicio.obtenerCliente(idCliente)));
    }

    @PostMapping("/agregar-negocio-favoritos/{idCliente}/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    agregarNegocioFavorito(@PathVariable String idCliente, @PathVariable String idNegocio) throws Exception {
        clienteServicio.agregarNegocioFavorito(idCliente,idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio agregado a favoritos correctamente"));
    }

    @PutMapping("/editar-password")
    public ResponseEntity<MensajeDTO<String>>
    cambiarPassword(@Valid @RequestBody CambioPasswordDTO cambioPasswordDTO) throws Exception {
        clienteServicio.cambiarPassword(cambioPasswordDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Contraseña actualizada correctamente"));
    }

    //Acciones que puede ejecutar un cliente respecto a los negocios

    @PostMapping("/agregar-negocio")
    public ResponseEntity<MensajeDTO<String>>
    agregarNegocio(@Valid @RequestBody AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        negocioServicio.agregarNegocio(agregarNegocioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio creado correctamente"));
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

    @GetMapping("/listar-negocios-propietario/{idPropietario}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    listarNegociosPropietario(@PathVariable String idPropietario) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.listarNegociosPropietario(idPropietario)));
    }


    //Acciones que puede ejecutar un cliente respecto a las calificaciones
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

    @PostMapping("/responder-calificacion")
    public ResponseEntity<MensajeDTO<String>>
    responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {
        calificacionServicio.responderCalificacion(responderCalificacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Respuesta agregada correctamente"));
    }

    //Acciones que puede ejecutar un cliente respecto a las publicaciones

    @PostMapping("/agregar-publicacion")
    public ResponseEntity<MensajeDTO<String>>
    agregarPublicacion(@Valid @RequestBody AgregarPublicacionDTO agregarPublicacionDTO) throws Exception {
        publicacionServicio.agregarPublicacion(agregarPublicacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Publicación creada correctamente"));
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

    //Acciones que puede ejecutar un cliente respecto a las opiniones
    @PostMapping("/agregar-opinion-publicacion")
    public ResponseEntity<MensajeDTO<String>>
    opinarPublicacion(@Valid @RequestBody OpinarPublicacionDTO opinarPublicacionDTO) throws Exception {
        opinionServicio.opinarPublicacion(opinarPublicacionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Opinión agregada correctamente"));
    }

    @PostMapping("reaccionar-opinion")
    public ResponseEntity<MensajeDTO<String>>
    reaccionarOpinion(@Valid @RequestBody ReaccionarOpinionDTO reaccionarOpinionDTO) throws Exception {
        opinionServicio.reaccionarOpinion(reaccionarOpinionDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Reacción agregada correctamente"));
    }

    //Acciones que puede ejecutar un cliente respecto a los eventos

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
    terminarEvento(@PathVariable String codigoEvento) throws Exception {
        eventoServicio.terminarEvento(codigoEvento);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Evento terminado correctamente"));
    }

}
