package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.emailDTO.EmailDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.AgregarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.DetalleRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.revisionDTO.ItemRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.RevisionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RevisionServicioImpl implements RevisionServicio {

    private final RevisionRepo revisionRepo;
    private final ModeradorServicio moderadorServicio;
    private final NegocioServicio negocioServicio;
    private final EmailServicio emailServicio;
    private final ClienteServicio clienteServicio;

    @Override
    public String agregarRevision(AgregarRevisionDTO agregarRevisionDTO) throws Exception {
        if (!moderadorServicio.existeModerador(agregarRevisionDTO.codigoModerador())) {
            throw new ResourceNotFoundException(agregarRevisionDTO.codigoModerador());
        }
        if (!negocioServicio.existeNegocio(agregarRevisionDTO.codigoNegocio())) {
            throw new ResourceNotFoundException(agregarRevisionDTO.codigoNegocio());
        }
        if (agregarRevisionDTO.estadoNegocio() == EstadoNegocio.PENDIENTE) {
            throw new Exception("No se puede asignar una revisión como pendiente");
        }
        if (negocioServicio.obtenerNegocioAprobado(agregarRevisionDTO.codigoNegocio()).estadoNegocio() != EstadoNegocio.PENDIENTE) {
            throw new Exception("No se puede asignar una revisión a un negocio que no está pendiente de revision");
        }
        Revision revision = new Revision();
        revision.setFecha(agregarRevisionDTO.fecha());
        revision.setCodigoModerador(agregarRevisionDTO.codigoModerador());
        revision.setCodigoNegocio(agregarRevisionDTO.codigoNegocio());
        revision.setDescripcion(agregarRevisionDTO.descripcion());
        revision.setEstadoNegocio(agregarRevisionDTO.estadoNegocio());

        Revision revisionGuardada = revisionRepo.save(revision);

        if (agregarRevisionDTO.estadoNegocio() == EstadoNegocio.APROBADO) {
            negocioServicio.aprobarNegocio(agregarRevisionDTO.codigoNegocio());
        }
        if (agregarRevisionDTO.estadoNegocio() == EstadoNegocio.RECHAZADO) {
            negocioServicio.rechazarNegocio(agregarRevisionDTO.codigoNegocio());
        }


        //Codigo envio correo
        emailServicio.enviarCorreo(new EmailDTO(
                "Tu negocio ha sido recibido una revisión",
                "Tu negocio ha sido recibido una revisión el día " + agregarRevisionDTO.fecha() + ": " +
                        "\n\nEstado: " + agregarRevisionDTO.estadoNegocio() +
                        "\n Descripcion: " + agregarRevisionDTO.descripcion(),
                clienteServicio.obtenerCliente(
                        negocioServicio.obtenerNegocioAprobado(agregarRevisionDTO.codigoNegocio()).codigoCliente()
                ).email()
        ));

        return revisionGuardada.getCodigoRevision();
    }

    @Override
    public DetalleRevisionDTO obtenerRevision(String codigoRevision) throws ResourceNotFoundException {
        Revision revision = obtenerRevisionID(codigoRevision);
        return new DetalleRevisionDTO(
                revision.getCodigoRevision(),
                revision.getFecha(),
                revision.getCodigoModerador(),
                revision.getCodigoNegocio(),
                revision.getDescripcion(),
                revision.getEstadoNegocio()
        );
    }

    @Override
    public List<ItemRevisionDTO> listarRevisionModerador(String codigoModerador) {
        return revisionRepo.findAllByCodigoModerador(codigoModerador);
    }

    @Override
    public List<ItemRevisionDTO> listarRevision() {
        List<Revision> listaRevision = revisionRepo.findAll();
        List<ItemRevisionDTO> itemsRevision = new ArrayList<>();
        for (Revision revision : listaRevision) {
            itemsRevision.add(new ItemRevisionDTO(
                    revision.getCodigoRevision(),
                    revision.getFecha(),
                    revision.getCodigoModerador(),
                    revision.getCodigoNegocio(),
                    revision.getDescripcion(),
                    revision.getEstadoNegocio()
            ));
        }
        return itemsRevision;
    }

    @Override
    public List<ItemRevisionDTO> listarRevisionNegocio(String codigoNegocio) throws Exception {
        //Obtenemos el detalle del negocio (valida existencia y si está activo)
        DetalleNegocioDTO detalleNegocioDTO = negocioServicio.obtenerNegocioAprobado(codigoNegocio);

        return revisionRepo.findAllByCodigoNegocio(detalleNegocioDTO.codigoNegocio());
    }

    private Revision obtenerRevisionID(String codigoRevision) throws ResourceNotFoundException {
        Optional<Revision> revision = revisionRepo.findById(codigoRevision);
        if (revision.isEmpty()) {
            throw new ResourceNotFoundException(codigoRevision);
        }
        return revision.get();

    }
}
