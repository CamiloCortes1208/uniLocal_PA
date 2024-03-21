package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;

import java.util.List;

public interface NegocioServicio {

    String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception;

    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;

    void eliminarNegocio(String idNegocio) throws Exception;

    List<DetalleNegocioDTO> buscarNegociosCategoria(String categoria);

    List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);

    List<DetalleNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception;

    void cambiarEstado(String idNegocio, EstadoNegocio estadoNegocio) throws Exception;

    void registrarRevision(String idNegocio, RegistrarRevisionDTO registrarRevisionDTO) throws Exception;

}