package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ItemClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
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
    ClienteServicio clienteServicio;

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
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);

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

    //Preguntar
    @Override
    public void eliminarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id" + idNegocio);
        }

        Negocio negocio = optionalNegocio.get();
        negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);

        negocioRepo.save(negocio);
    }

    @Override
    public void rechazarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id" + idNegocio);
        }

        Negocio negocio = optionalNegocio.get();
        negocio.setEstadoNegocio(EstadoNegocio.RECHAZADO);

        negocioRepo.save(negocio);
    }

    @Override
    public List<ItemNegocioDTO> buscarNegociosPorCategoria(String categoria) {
        List<Negocio> negocios =  negocioRepo.findAllByCategoriaNegocio(categoria);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            itemNegocioDTOS.add(
                    new ItemNegocioDTO(
                            negocio.getNombre(),
                            negocio.getDescripcion(),
                            negocio.getCategoriaNegocio(),
                            negocio.getUbicacion()
                    )
            );
        }
        return itemNegocioDTOS;
    }

    @Override
    public List<ItemNegocioDTO> buscarNegociosPorNombre(String nombre) {
        List<Negocio> negocios = negocioRepo.findAllByNombre(nombre);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            if(negocio.getEstadoRegistro().equals(EstadoRegistro.ACTIVO)){
                itemNegocioDTOS.add(
                        new ItemNegocioDTO(
                                negocio.getNombre(),
                                negocio.getDescripcion(),
                                negocio.getCategoriaNegocio(),
                                negocio.getUbicacion()
                        )
                );
            }
        }
        return itemNegocioDTOS;
    }

    //En caso de que no se dé un nombre exacto, busca por aquellos que tengan
    //coincidencias
    @Override
    public List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre) {
        List<Negocio> negocios = negocioRepo.findAllByNombreLikeIgnoreCase(nombre);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            if(negocio.getEstadoRegistro().equals(EstadoRegistro.ACTIVO)){
                itemNegocioDTOS.add(
                        new ItemNegocioDTO(
                                negocio.getNombre(),
                                negocio.getDescripcion(),
                                negocio.getCategoriaNegocio(),
                                negocio.getUbicacion()
                        )
                );
            }
        }
        return itemNegocioDTOS;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        List<Negocio> negocios =  negocioRepo.findAllByEstadoNegocio(estadoNegocio);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            if(negocio.getEstadoRegistro().equals(EstadoRegistro.ACTIVO)){
                itemNegocioDTOS.add(
                        new ItemNegocioDTO(
                                negocio.getNombre(),
                                negocio.getDescripcion(),
                                negocio.getCategoriaNegocio(),
                                negocio.getUbicacion()
                        )
                );
            }
        }
        return itemNegocioDTOS;
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception {
        return negocioRepo.listarNegociosCliente(idPropietario);
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

    @Override
    public void reactivarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id" + idNegocio);
        }

        Negocio negocio = optionalNegocio.get();

        if(negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }

    @Override
    public void aprobarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if(optionalNegocio.isEmpty()){
            throw new Exception("No existe un negocio con el id" + idNegocio);
        }

        Negocio negocio = optionalNegocio.get();

        if(negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }
}
