package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ModeradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModeradorServicioTest {
    @Autowired
    ModeradorServicio moderadorServicio;

    @Test
    public void actualizarModeradorTest() {
        ActualizarModeradorDTO actualizarModeradorDTO = new ActualizarModeradorDTO(
                "Moderador12938",
                "Gloria Davila",
                "gloriadav@email.com");
        Assertions.assertThrows(Exception.class, () -> moderadorServicio.actualizarModerador(actualizarModeradorDTO));
    }

}
