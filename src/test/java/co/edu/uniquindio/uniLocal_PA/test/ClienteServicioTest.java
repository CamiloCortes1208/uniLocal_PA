package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.*;
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
    public void registrarClienteTest() throws Exception {
        //Se crea un objeto de tipo RegistroClienteDTO que contenga email y nickname que ya exista
        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "Jacobo",
                "mi foto",
                "jacobish",
                "jacobo@email.com",
                "mipassword",
                "Quimbaya"
        );

        Assertions.assertThrows(Exception.class, () -> clienteServicio
                .registrarCliente(registroClienteDTO));
    }

    @Test
    public void agregarNegocioFavoritoTest() throws Exception {

        String codigoNegocioGuardado = clienteServicio
                .agregarNegocioFavorito("Cliente5", "Negocio1");

        Assertions.assertNotNull(codigoNegocioGuardado);
    }

    @Test
    public void editarPerfilTest() throws Exception {
        //Se crea un objeto de tipo ActualizarClienteDTO de un  cliente que no existe
        ActualizarClienteDTO actualizarClienteDTO = new ActualizarClienteDTO(
                "Cliente1",
                "Pepito Lopez",
                "nueva foto",
                "pepitolopez@email.com",
                "Armenia"
        );
        clienteServicio.editarPerfil(actualizarClienteDTO);
        //Se actualiza el cliente
        Assertions.assertEquals(clienteServicio.obtenerCliente("Cliente1").nombre(), "Pepito Lopez");

    }

    @Test
    public void obtenerClienteTest() throws Exception {

        //Se ejecuta el método con el Cliente5 con el fin de que se trabaje con una cuenta
        //ACTIVA
        DetalleClienteDTO detalleClienteDTO = clienteServicio.obtenerCliente("Cliente5");

        Assertions.assertEquals("Cartagena", detalleClienteDTO.ciudadResidencia());
    }

    @Test
    public void existeClienteTest() throws Exception {
        Assertions.assertEquals(false, clienteServicio.existeCliente("Cliente1290319071"));
    }

    @Test
    public void listarClientesTest() {
        //Se obtiene la lista de clientes
        List<ItemClienteDTO> lista = clienteServicio.listarClientes();

        //Se verifica que la lista no sea nula y que tenga 3 elementos
        Assertions.assertEquals(3, lista.size());
    }

    @Test
    public void eliminarClienteTest() throws Exception {

        //Se elimina el cliente con el id "Cliente1"


        //Al intentar obtener el cliente con el id "Cliente1" se debe lanzar una excepción
        Assertions.assertThrows(Exception.class, () -> clienteServicio.eliminarCliente("ClienteNoExistente"));
    }

    @Test
    public void cambiarPasswordTest() throws Exception {
        CambioPasswordDTO cambioPasswordDTO = new CambioPasswordDTO(
                "PasswordviejaErronea", "PasswordNueva", "Cliente1");
        Assertions.assertThrows(Exception.class, () -> clienteServicio.cambiarPassword(cambioPasswordDTO));
    }
}
