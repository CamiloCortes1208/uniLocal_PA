package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.RegistroClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.emailDTO.EmailDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.EmailServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServicioTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarCorreoTest() throws Exception {

        EmailDTO emailDTO = new EmailDTO(
                "Envío de correo de prueba",
                "Este es un correo de prueba",
                "pepitojuarez@gmail.com"
        );

        Assertions.assertDoesNotThrow( ()-> emailServicio.enviarCorreo(emailDTO));
    }

}
