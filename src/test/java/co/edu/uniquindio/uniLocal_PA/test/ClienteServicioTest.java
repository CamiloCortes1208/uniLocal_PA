package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private NegocioServicio negocioServicio;

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

        Assertions.assertThrows(Exception.class, () -> clienteServicio
                .registrarCliente(registroClienteDTO));
    }

    @Test
    public void obtenerClienteTest() throws Exception{

        //Se ejecuta el método con el Cliente5 con el fin de que se trabaje con una cuenta
        //ACTIVA
        ItemClienteDTO itemClienteDTO = clienteServicio.obtenerCliente("Cliente5");

        Assertions.assertEquals("Cali",itemClienteDTO.ciudadResidencia());

    }

    @Test
    public void editarPerfilTest() throws Exception{
        //Se crea un objeto de tipo ActualizarClienteDTO
        ActualizarClienteDTO actualizarClienteDTO = new ActualizarClienteDTO(
                "Cliente1",
                "Juan",
                "nueva foto",
                "juanc@email.com",
                "Armenia"
        );
        //Se actualiza el cliente
        Assertions.assertThrows(Exception.class, () -> clienteServicio
                .editarPerfil(actualizarClienteDTO)) ;
    }

    @Test
    public void eliminarClienteTest() throws Exception{

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
        Assertions.assertEquals(4, lista.size());
    }

    @Test
    public void agregarNegocioFavoritoTest() throws Exception {

        String codigoNegocioGuardado = clienteServicio
                .agregarNegocioFavorito("Cliente5","Negocio1");

        Assertions.assertNotNull(codigoNegocioGuardado);

    }

    @Test
    public void eliminarNegocioFavoritoTest() throws Exception {

        clienteServicio.eliminarNegocioFavorito("Cliente5","Negocio1");

        ItemClienteDTO itemClienteDTO = clienteServicio.obtenerCliente("Cliente5");

        //Se verifica que la lista esté vacía después de eliminar el negocio
        // con código "Negocio1" de los favoritos del cliente con código "Cliente1"
        Assertions.assertEquals(0, itemClienteDTO.listaNegociosFavoritos().size());
    }
}
