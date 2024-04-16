package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
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

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>>
    editarPerfil(@Valid @RequestBody ActualizarClienteDTO actualizarClienteDTO) throws Exception {
        clienteServicio.editarPerfil(actualizarClienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Cliente actualizado correctamente"));
    }

    @DeleteMapping("/eliminar/{idCuenta}")
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

    @GetMapping("/listar-todos")
    public ResponseEntity<MensajeDTO<List<ItemClienteDTO>>> listarClientes() {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clienteServicio.listarClientes() ));
    }

    @PostMapping("/agregar-negocio-favoritos/{idCliente}/{idNegocio}")
    public ResponseEntity<MensajeDTO<String>>
    agregarNegocioFavorito(@PathVariable String idCliente, @PathVariable String idNegocio) throws Exception {
        clienteServicio.agregarNegocioFavorito(idCliente,idNegocio);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Negocio agregado a favoritos correctamente"));
    }

    @PutMapping("/editar-password")
    void cambiarPassword(@Valid @RequestBody CambioPasswordDTO cambioPasswordDTO) {

    }
}
