package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.OpinionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OpinionServicioTest {
    @Autowired
    OpinionServicio opinionServicio;

    @Test
    public void opinarPublicacion() throws Exception {
        OpinarPublicacionDTO opinarPublicacionDTO = new OpinarPublicacionDTO(
                "Cliente1",
                "Publicacion23",
                "Excelente!");

        Assertions.assertThrows(Exception.class, () -> opinionServicio.opinarPublicacion(opinarPublicacionDTO));
    }

    @Test
    public void listarOpinionesPublicacion() throws ResourceNotFoundException {
        List<ItemOpinionDTO> listaOpinion = opinionServicio.listarOpinionesPublicacion("Publicacion2");
        Assertions.assertEquals(2, listaOpinion.size());
    }

    @Test
    public void reaccionarOpinion() throws Exception {
        ReaccionarOpinionDTO reaccionarOpinionDTO = new ReaccionarOpinionDTO("Opinion25", "Cliente5");
        Assertions.assertThrows(Exception.class, () -> opinionServicio.reaccionarOpinion(reaccionarOpinionDTO));
    }

    @Test
    public void listarOpinionesCliente() throws Exception {
        List<ItemOpinionDTO> listaOpinionesCliente = opinionServicio.listarOpinionesCliente("Cliente5");
        Assertions.assertEquals(2, listaOpinionesCliente.size());
    }
}
