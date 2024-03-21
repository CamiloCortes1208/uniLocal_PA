package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;

    public NegocioServicioImpl(NegocioRepo negocioRepo) {
        this.negocioRepo = negocioRepo;
    }

    @Override
    public String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        //Se crea el negocio
        Negocio negocio = new Negocio();

        //Se asignan los datos
        negocio.setNombre(agregarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(agregarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(agregarNegocioDTO.categoriaNegocio());
        negocio.setListaRutasImagenes(agregarNegocioDTO.listaImagenesNegocio());
        negocio.setListaTelefonos(agregarNegocioDTO.listaTelefonos());
        negocio.setListaHorarios(agregarNegocioDTO.listaHorarios());

        //Se guarda en la base de datos
        Negocio negocioGuardado = negocioRepo.save(negocio);

        //Se obtiene el código del negocio guardado
        return negocioGuardado.getCodigoNegocio();

    }

    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {
        //Buscamos el negocio que se quiere actualizar
        Optional<Negocio> optionalNegocio = negocioRepo.findById(actualizarNegocioDTO.codigoNegocio());
        //Si no se encontró el negocio, lanzamos una excepción
        if(optionalNegocio.isEmpty()){
            throw new Exception("No se encontró el negocio a actualizar");
        }
        //Obtenemos el negocio que se quiere actualizar y le asignamos los nuevos valores
        Negocio negocio = optionalNegocio.get();
        negocio.setNombre(actualizarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(actualizarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(actualizarNegocioDTO.categoriaNegocio());
        negocio.setListaRutasImagenes(actualizarNegocioDTO.listaImagenesNegocio());
        negocio.setListaTelefonos(actualizarNegocioDTO.listaTelefonos());
        negocio.setListaHorarios(actualizarNegocioDTO.listaHorarios());
        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro sino que
        // actualiza el que ya existe
        negocioRepo.save(negocio);
    }

    @Override
    public void eliminarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id" + idNegocio);
        }

        Negocio negocio = optionalNegocio.get();
        negocio.setEstadoNegocio(EstadoNegocio.RECHAZADO);
    }

    @Override
    public List<DetalleNegocioDTO> buscarNegociosCategoria(String categoria) {
        List<Negocio> negocios =  negocioRepo.findAllByCategoria(categoria);

        //Creamos una lista de DTOs de negocios
        List<DetalleNegocioDTO> detalleNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            detalleNegocioDTOS.add(
                    new DetalleNegocioDTO(
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCategoriaNegocio(),
                            negocio.getListaRutasImagenes(),
                            negocio.getListaTelefonos(),
                            negocio.getListaHorarios()
                    )
            );
        }
        return detalleNegocioDTOS;
    }

    @Override
    public List<DetalleNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        List<Negocio> negocios =  negocioRepo.findAllByEstadoNegocio(estadoNegocio);

        //Creamos una lista de DTOs de negocios
        List<DetalleNegocioDTO> detalleNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            detalleNegocioDTOS.add(
                    new DetalleNegocioDTO(
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCategoriaNegocio(),
                            negocio.getListaRutasImagenes(),
                            negocio.getListaTelefonos(),
                            negocio.getListaHorarios()
                    )
            );
        }
        return detalleNegocioDTOS;
    }

    //PENDIENTE
    @Override
    public List<DetalleNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception {
        return null;
    }

    @Override
    public void cambiarEstado(String idNegocio, EstadoNegocio estadoNegocio) throws Exception {

        //Se obtiene un negocio en base a su id
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id "+ idNegocio);
        }

        //Se obtiene el negocio y se cambia su estado
        Negocio negocio = optionalNegocio.get();
        negocio.setEstadoNegocio(estadoNegocio);

        //Se actualiza el repositorio con el estado del negocio actualizado
        negocioRepo.save(negocio);
    }

    @Override
    public void registrarRevision(String idNegocio, RegistrarRevisionDTO registrarRevisionDTO) throws Exception {

        //Se obtiene un negocio en base a su id
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id "+ idNegocio);
        }

        //Se obtiene el negocio y se cambia su estado
        Negocio negocio = optionalNegocio.get();

        //Se crea la revisión del negocio
        Revision revision = new Revision();
        revision.setEstadoNegocio( registrarRevisionDTO.estadoNegocio() );
        revision.setDescripcion( registrarRevisionDTO.descripcion() );

        //Se añade la revisión a la lista de revisiones del negocio
        negocio.getListaRevisiones().add(revision);

        //Se actualiza la información del negocio en la base de datos
        negocioRepo.save(negocio);

    }
}
