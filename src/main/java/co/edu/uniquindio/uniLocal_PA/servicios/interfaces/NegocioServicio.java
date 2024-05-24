package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.*;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;

import java.util.List;

public interface NegocioServicio {

    String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception;
    DetalleNegocioDTO obtenerNegocioAprobado(String idNegocio) throws Exception;
    DetalleNegocioDTO obtenerNegocioRechazado(String idNegocio) throws Exception;
    List<ItemNegocioDTO> listarNegociosFavoritosCliente(String idCliente) throws Exception;
    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;
    void eliminarNegocio(String idNegocio) throws Exception;
    boolean existeNegocio(String idNegocio);
    void rechazarNegocio(String idNegocio) throws Exception;
    List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio);
    List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre);
    List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);
    List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception;
    List<ItemNegocioDTO> listarNegociosUbicacion(UbicacionRedondaDTO ubicacionRedondaDTO);
    List<ItemNegocioDTO> listarNegociosRecomendados(Ubicacion ubicacion);
    List<ItemNegocioDTO> listarNegociosPropietarioRechazados(String codigoCliente);
    void aprobarNegocio(String idNegocio) throws Exception;
    String agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception;

}