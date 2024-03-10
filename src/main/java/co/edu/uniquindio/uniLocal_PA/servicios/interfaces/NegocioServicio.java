package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;

import java.util.List;

public interface NegocioServicio {

    void agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception;

    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;

    void eliminarNegocio(String idNegocio);

    List<Negocio> buscarNegocios(String categoria, Ubicacion ubicacion);

    List<Negocio> filtrarPorEstado(EstadoNegocio estadoNegocio);

    List<Negocio> listarNegociosPropietario(String idPropietario) throws Exception;

    void cambiarEstado(EstadoNegocio estadoNegocio);

    void registrarRevision(RegistrarRevisionDTO registrarRevisionDTO) throws Exception;

}