package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.AgregarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.RevisionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RevisionServicioTest {
    @Autowired
    RevisionServicio revisionServicio;

    @Test
    public void agregarRevisionTest() throws Exception {
        AgregarRevisionDTO agregarRevisionDTO = new AgregarRevisionDTO(
                LocalDateTime.now(),
                "Moderador1",
                "Negocio3",
                "Todo correcto",
                EstadoNegocio.APROBADO
        );
        String codigo = revisionServicio.agregarRevision(agregarRevisionDTO);
        Assertions.assertEquals("Todo correcto", revisionServicio.obtenerRevision(codigo).descripcion());
    }

    @Test
    public void obtenerRevisionTest() throws ResourceNotFoundException {
        Assertions.assertEquals("Todo cumple con los requisitos y normas de la pagina", revisionServicio.obtenerRevision("Revision1").descripcion());
    }

    @Test
    public void listarRevisionModeradorTest() {
        Assertions.assertEquals(3, revisionServicio.listarRevisionModerador("Moderador1").size());
    }

    @Test
    public void listarRevisionTest() {
        Assertions.assertEquals(6, revisionServicio.listarRevision().size());
    }

    @Test
    public void listarRevisionNegocioTest() throws Exception {
        Assertions.assertEquals(1, revisionServicio.listarRevisionNegocio("Negocio1").size());
    }
}
