package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.impl.ClienteServicioImpl;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    public void registrarClienteTest() throws Exception{
        //Se crea un objeto de tipo RegistroClienteDTO
        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "Juan",
                "mi foto",
                "juanito",
                "juan@email.com",
                "mipassword",
                "Armenia"
        );
        //Se registra el cliente
        String codigo = clienteServicio.registrarCliente(registroClienteDTO);
        Assertions.assertNotNull(codigo);
    }

    @Test
    public void obtenerClienteTest() throws Exception{

        ItemClienteDTO itemClienteDTO = clienteServicio.obtenerCliente("Cliente1");

        Assertions.assertEquals("Armenia",itemClienteDTO.ciudadResidencia());

    }

    @Test
    public void editarPerfilTest() throws Exception{
        //Se crea un objeto de tipo ActualizarClienteDTO
        ActualizarClienteDTO actualizarClienteDTO = new ActualizarClienteDTO(
                "Cliente1",
                "Juan",
                "nueva foto",
                "juan@email.com",
                "Armenia"
        );
        //Se actualiza el cliente
        clienteServicio.editarPerfil(actualizarClienteDTO);

        //Con el método obtenerCliente se obtiene el cliente con el id "Cliente1"
        ItemClienteDTO itemClienteDTO = clienteServicio.obtenerCliente("Cliente1");

        //Se verifica que la foto de perfil sea la misma que se actualizó
        Assertions.assertEquals("nueva foto", itemClienteDTO.fotoPerfil());
    }

    @Test
    public void eliminarTest() throws Exception{
        //Se elimina el cliente con el id "Cliente1"
        clienteServicio.eliminarCuenta("Cliente1");
        //Al intentar obtener el cliente con el id "Cliente1" se debe lanzar una excepción
        Assertions.assertThrows(Exception.class, () -> clienteServicio.obtenerCliente("Cliente1") );
    }

    @Test
    public void listarClientesTest() {
        //Se obtiene la lista de clientes
        List<ItemClienteDTO> lista = clienteServicio.listarClientes();

        //Se verifica que la lista no sea nula y que tenga 3 elementos
        Assertions.assertEquals(3, lista.size());
    }


}
