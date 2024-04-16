package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.*;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @PostMapping("/registrar-cliente")
    String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {

    }

    @PutMapping("/editar-perfil")
    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception {

    }

    @DeleteMapping("/eliminar/{idCuenta}")
    void eliminarCliente(String idCuenta) throws Exception {

    }

    @GetMapping("/obtener/{idCliente}")
    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception {

    }

    @GetMapping("/listar-todos")
    List<ItemClienteDTO> listarClientes() {

    }

    @PostMapping("/agregar-negocio-favoritos/{idCliente},{idNegocio}")
    String agregarNegocioFavorito(String idCliente, String idNegocio) {

    }

    @PutMapping("/editar-password")
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) {

    }
}
