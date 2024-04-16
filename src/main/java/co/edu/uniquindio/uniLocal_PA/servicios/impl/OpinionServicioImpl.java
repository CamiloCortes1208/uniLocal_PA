package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.OpinionRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.PublicacionRepo;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.OpinionServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OpinionServicioImpl implements OpinionServicio {

    private final OpinionRepo opinionRepo;
    ClienteServicio clienteServicio;
    PublicacionServicio publicacionServicio;

    public OpinionServicioImpl(OpinionRepo opinionRepo, PublicacionRepo publicacionRepo, ClienteRepo clienteRepo) {
        this.opinionRepo = opinionRepo;
    }


    @Override
    public String opinarPublicacion(OpinarPublicacionDTO opinarPublicacionDTO) throws Exception {

        if (!publicacionServicio.existePublicacion(opinarPublicacionDTO.codigoPublicacion())){
            throw new ResourceNotFoundException(opinarPublicacionDTO.codigoPublicacion());
        }

        if(!clienteServicio.existeCliente(opinarPublicacionDTO.codigoCliente())){
            throw new ResourceNotFoundException(opinarPublicacionDTO.codigoCliente());
        }

        Opinion opinion = new Opinion();

        opinion.setCodigoPublicacion(opinarPublicacionDTO.codigoPublicacion());
        opinion.setCodigoCliente(opinarPublicacionDTO.codigoCliente());
        opinion.setFecha(LocalDateTime.now());
        opinion.setMensaje(opinarPublicacionDTO.mensaje());

        Opinion opinionGuardada = opinionRepo.save(opinion);

        return opinionGuardada.getCodigoOpinion();
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesPublicacion(String idPublicacion) throws ResourceNotFoundException {
        return opinionRepo.findAllByCodigoPublicacion(idPublicacion);
    }

    @Override
    public void reaccionarOpinion(ReaccionarOpinionDTO reaccionarOpinionDTO) throws Exception {

        if(!clienteServicio.existeCliente(reaccionarOpinionDTO.idCliente())){
            throw new ResourceNotFoundException(reaccionarOpinionDTO.idCliente());
        }

        Opinion opinion = obtenerOpinionID(reaccionarOpinionDTO.idOpinion());

        if (opinion.getListaMeGustas().contains(reaccionarOpinionDTO.idCliente())){
            opinion.getListaMeGustas().remove(reaccionarOpinionDTO.idCliente());
        }else{
            opinion.getListaMeGustas().add(reaccionarOpinionDTO.idCliente());
        }
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesCliente(String idCliente) throws Exception {
        return opinionRepo.findAllByCodigoCliente(idCliente);
    }

    //Metodos para verificar existencia de datos
    private Opinion obtenerOpinionID(String idOpinion) throws ResourceNotFoundException {

        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if (optionalOpinion.isEmpty()){
            throw new ResourceNotFoundException(idOpinion);
        }

        return optionalOpinion.get();
    }
}
