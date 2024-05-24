package co.edu.uniquindio.uniLocal_PA.test;

import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.*;
import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NegocioServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private NegocioServicio negocioServicio;

    @Test
    public void agregarNegocioTest() throws Exception {
        List<String> listaImagenesNegocio = new ArrayList<>();
        listaImagenesNegocio.add("rutaimagennegocio1");

        List<String> listaTelefonos = new ArrayList<>();
        listaTelefonos.add("3091238764");

        List<Horario> listaHorarios = new ArrayList<>();
        listaHorarios.add(new Horario("7:00", "22:00", "MIERCOLES"));

        Ubicacion ubicacion = new Ubicacion(10.023, -65.2138);

        AgregarNegocioDTO agregarNegocioDTO = new AgregarNegocioDTO(
                "Cliente1",
                "Restaurante Mexicano el chilito",
                "Restaurante de comida mexicana en Armnia",
                CategoriaNegocio.RESTAURANTE,
                listaImagenesNegocio,
                listaTelefonos,
                listaHorarios,
                ubicacion);

        String codigoNegocio = negocioServicio.agregarNegocio(agregarNegocioDTO);
        Assertions.assertEquals("Restaurante Mexicano el chilito", negocioServicio.obtenerNegocioAprobado(codigoNegocio).nombre());
    }

    @Test
    public void actualizarNegocioTest() throws Exception {
        /*List<String> listaImagenesNegocio = new ArrayList<>();
        listaImagenesNegocio.add("rutaimagennegocio1");

        List<String> listaTelefonos = new ArrayList<>();
        listaTelefonos.add("3091238764");

        List<Horario> listaHorarios = new ArrayList<>();
        listaHorarios.add(new Horario("7:00", "22:00", "MIERCOLES"));

        Ubicacion ubicacion = new Ubicacion(10.023, -65.2138);

        ActualizarNegocioDTO actualizarNegocioDTO = new ActualizarNegocioDTO(
                "Negocio3",
                "Ferreteria los milagros",
                "Ferreteria ubicada en el barrio los milagros",
                CategoriaNegocio.FERRETERIA,
                listaImagenesNegocio,
                listaTelefonos,
                listaHorarios,
                ubicacion);

        negocioServicio.actualizarNegocio(actualizarNegocioDTO);
        Assertions.assertEquals("Ferreteria los milagros", negocioServicio.obtenerNegocio(actualizarNegocioDTO.codigoNegocio()).nombre());
        */
    }

    @Test
    public void eliminarNegocioTest() throws Exception {
        negocioServicio.eliminarNegocio("Negocio4");
        Assertions.assertEquals(EstadoRegistro.INACTIVO, negocioServicio.obtenerNegocioAprobado("Negocio4").estadoRegistro());
    }

    @Test
    public void rechazarNegocioTest() throws Exception {
        negocioServicio.rechazarNegocio("Negocio4");
        Assertions.assertEquals(EstadoNegocio.RECHAZADO, negocioServicio.obtenerNegocioAprobado("Negocio4").estadoNegocio());
    }

    @Test
    public void aprobarNegocioTest() throws Exception {
        negocioServicio.aprobarNegocio("Negocio2");
        Assertions.assertEquals(EstadoNegocio.APROBADO, negocioServicio.obtenerNegocioAprobado("Negocio4").estadoNegocio());
    }

    @Test
    public void obtenerNegocioTest() throws Exception {
        Assertions.assertEquals("Tecnologic S.A.S", negocioServicio.obtenerNegocioAprobado("Negocio4").nombre());

    }

    @Test
    public void buscarNegociosPorCategoriaTest() {
        List<ItemNegocioDTO> listaNegocios = negocioServicio.buscarNegociosPorCategoria(CategoriaNegocio.CAFETERIA);
        for (ItemNegocioDTO itemNegocioDTO: listaNegocios){
            System.out.println(itemNegocioDTO.toString());
        }
        //Assertions.assertEquals(1, listaNegocios.size());
    }

    @Test
    public void buscarNegociosPorNombreSimilarTest() {
        List<ItemNegocioDTO> itemNegocioDTOS = negocioServicio.buscarNegociosPorNombreSimilar("cafeteria");
        for (ItemNegocioDTO itemNegocioDTO: itemNegocioDTOS){
            System.out.println(itemNegocioDTO.toString());
        }
        //Assertions.assertEquals(1, listaNegocios.size());
    }

    @Test
    public void filtrarPorEstadoTest() {
        Assertions.assertEquals(1, negocioServicio.filtrarPorEstado(EstadoNegocio.APROBADO).size());
    }

    @Test
    public void listarNegociosPropietarioTest() throws Exception {
        List<ItemNegocioDTO> list = negocioServicio.listarNegociosPropietario("Cliente1");
        for (ItemNegocioDTO itemNegocioDTO: list){
            System.out.println(itemNegocioDTO.codigoNegocio()+" "+itemNegocioDTO.codigoCliente()+" "+itemNegocioDTO.nombre()+" "+itemNegocioDTO.descripcion()+" "+itemNegocioDTO.categoriaNegocio()+" "+itemNegocioDTO.estadoNegocio()+" "+itemNegocioDTO.ubicacion()+" "+itemNegocioDTO.listaTelefonos()+" "+itemNegocioDTO.listaRutasImagenes()+" "+itemNegocioDTO.listaHorarios()+" "+itemNegocioDTO.estadoNegocio());
        }
        Assertions.assertEquals(1,list.size() );
    }
    @Test
    public void existeNegocio() {
        Assertions.assertFalse(negocioServicio.existeNegocio("Negocio10231823"));
    }

    @Test
    public void listarNegociosFavoritosClienteTest() throws Exception {
        List<ItemNegocioDTO> itemNegocioDTOS = negocioServicio.listarNegociosFavoritosCliente("Cliente1");
        for (ItemNegocioDTO itemNegocioDTO: itemNegocioDTOS){
            System.out.println(itemNegocioDTO.toString());
        }
        //Assertions.assertEquals(1, negocioServicio.listarNegociosFavoritosCliente("Cliente1").size());
    }

    @Test
    public void listarNegociosPorUbicaionTest(){
        Ubicacion ubicacion = new Ubicacion(4.12355, -75.12305);
        UbicacionRedondaDTO ubicacionRedondaDTO = new UbicacionRedondaDTO(ubicacion, 2);
        List<ItemNegocioDTO> itemNegocioDTOS = negocioServicio.listarNegociosUbicacion(ubicacionRedondaDTO);
        for (ItemNegocioDTO itemNegocioDTO: itemNegocioDTOS){
            System.out.println(itemNegocioDTO.toString());
        }
    }

    @Test
    public  void listarNegociosRecomendadosZona(){
        Ubicacion ubicacion = new Ubicacion(4.12355, -75.12305);
        List<ItemNegocioDTO> itemNegocioDTOS = negocioServicio.listarNegociosRecomendados(ubicacion);
        for (ItemNegocioDTO itemNegocioDTO: itemNegocioDTOS){
            System.out.println(itemNegocioDTO.toString());
        }
    }

}
