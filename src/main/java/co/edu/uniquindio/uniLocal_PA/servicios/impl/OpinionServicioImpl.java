package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.OpinionRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.PublicacionRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.OpinionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OpinionServicioImpl implements OpinionServicio {

    private final OpinionRepo opinionRepo;
    private final PublicacionRepo publicacionRepo;
    private final ClienteRepo clienteRepo;

    public OpinionServicioImpl(OpinionRepo opinionRepo, PublicacionRepo publicacionRepo, ClienteRepo clienteRepo) {
        this.opinionRepo = opinionRepo;
        this.publicacionRepo = publicacionRepo;
        this.clienteRepo = clienteRepo;
    }


    @Override
    public String opinarPublicacion(String idPublicacion, String idCliente, OpinarPublicacionDTO opinarPublicacionDTO) throws Exception {

        if (!existePublicacion(idPublicacion)){
            throw new ResourceNotFoundException(idPublicacion);
        }
        if (!existeCliente(idCliente)){
            throw new ResourceNotFoundException(idCliente);
        }

        Opinion opinion = new Opinion();

        opinion.setMensaje(opinarPublicacionDTO.mensaje());
        opinion.setFecha(LocalDateTime.now());
        opinion.setCodigoCliente(idCliente);

        Opinion opinionGuardada = opinionRepo.save(opinion);

        Publicacion publicacion = buscarPublicacionID(idPublicacion);
        publicacion.getListaOpiniones().add(opinionGuardada.getCodigoOpinion());

        return opinionGuardada.getCodigoOpinion();
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesPublicacion(String idPublicacion) throws ResourceNotFoundException {
        Publicacion publicacion = buscarPublicacionID(idPublicacion);

        List<ItemOpinionDTO> items = new ArrayList<>();

        for (String opinionID: publicacion.getListaOpiniones()){
            Opinion opinion = buscarOpinionID(opinionID);

            items.add(new ItemOpinionDTO(opinion.getCodigoCliente(),opinion.getCodigoOpinion()
                    ,opinion.getMensaje(),opinion.getFecha(),opinion.getListaMeGustas()));
        }
        return items;
    }

    @Override
    public void reaccionarOpinion(String idOpinion, String idCliente) throws Exception {
        if (!existeCliente(idCliente)){
            throw new ResourceNotFoundException(idCliente);
        }
        Opinion opinion = obtenerOpinionID(idOpinion);

        if (opinion.getListaMeGustas().contains(idCliente)){
            opinion.getListaMeGustas().remove(idCliente);
        }else{
            opinion.getListaMeGustas().add(idCliente);
        }
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesCliente(String idCliente) throws Exception {
        if (!existeCliente(idCliente)){
            throw new ResourceNotFoundException(idCliente);
        }
        List<Opinion> listaOpinionesCliente = opinionRepo.findAllByCodigoCliente(idCliente);

        List<ItemOpinionDTO> items = new ArrayList<>();

        for (Opinion opinion: listaOpinionesCliente){
            items.add(new ItemOpinionDTO(opinion.getCodigoCliente(),opinion.getCodigoOpinion()
                    ,opinion.getMensaje(),opinion.getFecha(),opinion.getListaMeGustas()));
        }
        return items;
    }

    //Metodos para verificar existencia de datos
    private Opinion obtenerOpinionID(String idOpinion) throws ResourceNotFoundException {

        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if (optionalOpinion.isEmpty()){
            throw new ResourceNotFoundException(idOpinion);
        }

        Opinion opinion = optionalOpinion.get();

        return opinion;
    }
    private Publicacion obtenerPublicacionID(String idPublicacion) throws ResourceNotFoundException {

        Optional<Publicacion> optionalPublicacion = publicacionRepo.findById(idPublicacion);

        if (optionalPublicacion.isEmpty()){
            throw new ResourceNotFoundException(idPublicacion);
        }

        Publicacion publicacion = optionalPublicacion.get();

        return publicacion;
    }

    private Publicacion buscarPublicacionID(String idPublicacion) throws ResourceNotFoundException {
        Optional<Publicacion> optionalPublicacion = publicacionRepo.findById(idPublicacion);

        if (optionalPublicacion.isEmpty()){
            throw new ResourceNotFoundException(idPublicacion);
        }

        return optionalPublicacion.get();
    }
    private Opinion buscarOpinionID(String idOpinion) throws ResourceNotFoundException {
        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if (optionalOpinion.isEmpty()){
            throw new ResourceNotFoundException(idOpinion);
        }
        return optionalOpinion.get();
    }
    private boolean existePublicacion(String idPublicacion){
        return publicacionRepo.findById(idPublicacion).isPresent();
    }
    private boolean existeCliente(String idCliente) {
        return clienteRepo.findById(idCliente).isPresent();
    }
}
