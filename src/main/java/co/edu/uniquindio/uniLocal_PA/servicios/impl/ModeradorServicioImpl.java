package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.DetalleModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ModeradorRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ModeradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final ModeradorRepo moderadorRepo;

    @Override
    public void actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception {
        Optional<Moderador> optionalModerador = moderadorRepo.findById(actualizarModeradorDTO.id());
        if (optionalModerador.isEmpty()) {
            throw new ResourceNotFoundException(actualizarModeradorDTO.id());
        }

        Moderador moderador = optionalModerador.get();
        moderador.setNombre(actualizarModeradorDTO.nombre());
        moderador.setEmail(actualizarModeradorDTO.email());

        moderadorRepo.save(moderador);
    }

    @Override
    public boolean existeModerador(String codigoModerador) {
        return moderadorRepo.findById(codigoModerador).isPresent();
    }

    @Override
    public DetalleModeradorDTO obtenerModerador(String codigoModerador) throws Exception {
        Moderador moderador = obtenerModeradorID(codigoModerador);
        if (moderador.getEstadoRegistro().equals(EstadoRegistro.INACTIVO)){
            throw new Exception("El moderador con el id "+ codigoModerador + " tiene su cuenta inactiva");
        }
        //Retornamos el moderador en formato DTO
        return new DetalleModeradorDTO(moderador.getCodigo(),moderador.getNombre(),moderador.getFotoPerfil(),moderador.getEmail(),moderador.getEstadoRegistro());
    }


    //Metodos para verificar existencia de datos
    private Moderador obtenerModeradorID(String idModerador) throws ResourceNotFoundException {
        Optional<Moderador> optionalModerador = moderadorRepo.findById(idModerador);

        if (optionalModerador.isEmpty()) {
            throw new ResourceNotFoundException(idModerador);
        }

        return optionalModerador.get();
    }
}
