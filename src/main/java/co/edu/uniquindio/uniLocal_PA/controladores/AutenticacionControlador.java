package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.LoginClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.TokenDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.LoginModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.AutenticacionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionControlador {

    private final AutenticacionServicio autenticacionServicio;

    @PostMapping("/login-cliente")
    public ResponseEntity<MensajeDTO<TokenDTO>>
    iniciarSesionCliente(@Valid @RequestBody LoginClienteDTO loginClienteDTO) throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.iniciarSesionCliente(loginClienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/login-moderador")
    public ResponseEntity<MensajeDTO<TokenDTO>>
    iniciarSesionModerador(@Valid @RequestBody LoginModeradorDTO loginModeradorDTO) throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.iniciarSesionModerador(loginModeradorDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

}