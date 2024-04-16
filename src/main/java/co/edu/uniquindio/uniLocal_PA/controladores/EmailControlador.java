package co.edu.uniquindio.uniLocal_PA.controladores;

import co.edu.uniquindio.uniLocal_PA.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal_PA.dto.emailDTO.EmailDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.EmailServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailControlador {
    private final EmailServicio emailServicio;

    @PostMapping("/enviar-correo")
    public ResponseEntity<MensajeDTO<String>>
    enviarCorreo(@RequestBody EmailDTO emailDTO) throws Exception {
        emailServicio.enviarCorreo(emailDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                "Correo enviado correctamente"));
    }
}
