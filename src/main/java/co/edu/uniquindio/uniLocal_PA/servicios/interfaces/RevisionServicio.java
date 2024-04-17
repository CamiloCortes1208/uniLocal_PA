package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.AgregarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.DetalleRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.ItemRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;

import java.util.List;

public interface RevisionServicio {
    String agregarRevision(AgregarRevisionDTO agregarRevisionDTO) throws Exception;

    DetalleRevisionDTO obtenerRevision(String codigoRevision) throws ResourceNotFoundException;

    List<ItemRevisionDTO> listarRevisionModerador(String codigoModerador);

    List<ItemRevisionDTO> listarRevision();

    List<ItemRevisionDTO> listarRevisionNegocio(String codigoNegocio);
}
