package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;

import java.util.List;

public interface NegocioServicio {

    String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception;

    ItemNegocioDTO obtenerNegocio(String idNegocio) throws Exception;

    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;

    void eliminarNegocio(String idNegocio) throws Exception;

    boolean existeNegocio(String idNegocio);

    void rechazarNegocio(String idNegocio) throws Exception;

    List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio);

    List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre);

    List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);

    List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception;

    void cambiarEstado(String idNegocio, EstadoNegocio estadoNegocio) throws Exception;

    void reactivarNegocio(String idNegocio) throws Exception;

    void aprobarNegocio(String idNegocio) throws Exception;

}