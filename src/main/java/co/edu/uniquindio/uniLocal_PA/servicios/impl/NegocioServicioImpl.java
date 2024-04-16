package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
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
    private ClienteServicio clienteServicio;

    public NegocioServicioImpl(NegocioRepo negocioRepo) {
        this.negocioRepo = negocioRepo;
    }

    @Override
    public String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        //Se crea el negocio
        Negocio negocio = new Negocio();

        //Se asignan los datos
        negocio.setCodigoCliente(agregarNegocioDTO.codigoCliente());
        negocio.setNombre(agregarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(agregarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(agregarNegocioDTO.categoriaNegocio());
        negocio.setListaTelefonos(agregarNegocioDTO.listaTelefonos());
        negocio.setListaRutasImagenes(agregarNegocioDTO.listaImagenesNegocio());
        negocio.setListaHorarios(agregarNegocioDTO.listaHorarios());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);
        negocio.setEstadoRegistro(EstadoRegistro.ACTIVO);

        //Se guarda en la base de datos
        Negocio negocioGuardado = negocioRepo.save(negocio);

        //Se obtiene el código del negocio guardado
        return negocioGuardado.getCodigoNegocio();

    }

    @Override
    public DetalleNegocioDTO obtenerNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        DetalleNegocioDTO detalleNegocioDTO = new DetalleNegocioDTO(
                negocio.getCodigoNegocio(),
                negocio.getCodigoCliente(),
                negocio.getNombre(),
                negocio.getDescripcion(),
                negocio.getCategoriaNegocio(),
                negocio.getEstadoNegocio(),
                negocio.getUbicacion(),
                negocio.getListaTelefonos(),
                negocio.getListaRutasImagenes(),
                negocio.getListaHorarios(),
                negocio.getEstadoRegistro()
        );

        return detalleNegocioDTO;
    }

    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {

        Negocio negocio = obtenerNegocioID(actualizarNegocioDTO.codigoNegocio());

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

        Negocio negocio = obtenerNegocioID(idNegocio);

        negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);

        negocioRepo.save(negocio);
    }

    @Override
    public void rechazarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        negocio.setEstadoNegocio(EstadoNegocio.RECHAZADO);

        negocioRepo.save(negocio);
    }

    @Override
    public List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio) {
        List<Negocio> negocios =  negocioRepo.findAllByCategoriaNegocio(categoriaNegocio);

        List<ItemNegocioDTO> listaItemNegocioDTO = listarNegocios(negocios);

        return listaItemNegocioDTO;
    }

    //En caso de que no se dé un nombre exacto, busca por aquellos que tengan
    //coincidencias
    @Override
    public List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre) {

        List<Negocio> negocios = negocioRepo.findAllByNombreLikeIgnoreCase(nombre);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> listaItemNegocioDTO = listarNegocios(negocios);

        return listaItemNegocioDTO;
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {

        List<Negocio> negocios =  negocioRepo.findAllByEstadoNegocio(estadoNegocio);

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> listaNegociosDTO = listarNegocios(negocios);

        return listaNegociosDTO;

    }

    @Override
    public List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception {
        return negocioRepo.findAllByCodigoCliente(idPropietario);
    }

    @Override
    public void cambiarEstado(String idNegocio, EstadoNegocio estadoNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        negocio.setEstadoNegocio(estadoNegocio);

        //Se actualiza el repositorio con el estado del negocio actualizado
        negocioRepo.save(negocio);
    }

    @Override
    public void reactivarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        if(negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }

    @Override
    public void aprobarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        if(negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }

    //Metodos para verificar existencia de datos
    private Negocio obtenerNegocioID(String idNegocio) throws ResourceNotFoundException {

        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if (optionalNegocio.isEmpty()){
            throw new ResourceNotFoundException(idNegocio);
        }

        Negocio negocio = optionalNegocio.get();

        return negocio;
    }

    @Override
    public boolean existeNegocio(String idNegocio) {
        return negocioRepo.findById(idNegocio).isPresent();
    }

    private List<ItemNegocioDTO> listarNegocios(List<Negocio> negocios) {

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            if(negocio.getEstadoRegistro().equals(EstadoRegistro.ACTIVO) &&
            negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
                itemNegocioDTOS.add(
                        new ItemNegocioDTO(
                                negocio.getCodigoNegocio(),
                                negocio.getCodigoCliente(),
                                negocio.getNombre(),
                                negocio.getDescripcion(),
                                negocio.getCategoriaNegocio(),
                                negocio.getEstadoNegocio(),
                                negocio.getUbicacion(),
                                negocio.getListaTelefonos(),
                                negocio.getListaRutasImagenes(),
                                negocio.getListaHorarios(),
                                negocio.getEstadoRegistro()
                        )
                );
            }
        }
        return itemNegocioDTOS;
    }
}
