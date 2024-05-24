package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.DetalleClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.negocioDTO.*;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;
    private final ClienteServicio clienteServicio;

    @Override
    public String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        //Obtenemos el cliente (Con esto validamos que el cliente exista y que esté activo)
        DetalleClienteDTO detalleClienteDTO = clienteServicio.obtenerCliente(agregarNegocioDTO.codigoCliente());

        //Se crea el negocio
        Negocio negocio = new Negocio();

        //Se asignan los datos
        negocio.setCodigoCliente(detalleClienteDTO.id());
        negocio.setNombre(agregarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(agregarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(agregarNegocioDTO.categoriaNegocio());
        negocio.setListaTelefonos(agregarNegocioDTO.listaTelefonos());
        negocio.setListaRutasImagenes(agregarNegocioDTO.listaImagenesNegocio());
        negocio.setListaHorarios(agregarNegocioDTO.listaHorarios());
        negocio.setUbicacion(agregarNegocioDTO.ubicacion());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);
        negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);

        //Se guarda en la base de datos
        Negocio negocioGuardado = negocioRepo.save(negocio);

        //Se obtiene el código del negocio guardado
        return negocioGuardado.getCodigoNegocio();

    }
    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {
        //Cliente que intenta actualizar el negocio, se valida si el cliente existe y si está activo
        DetalleClienteDTO detalleClienteDTO = clienteServicio.obtenerCliente(actualizarNegocioDTO.codigoCliente());
        //Valida si existe el negocio
        Negocio negocio = obtenerNegocioID(actualizarNegocioDTO.codigoNegocio());
        if (negocio.getEstadoRegistro().equals(EstadoRegistro.INACTIVO)){
            throw new Exception("El negocio está inactivo");
        }
        if (!negocio.getCodigoCliente().equals(detalleClienteDTO.id())){
            throw new Exception("El id del cliente y el id del dueño del negocio no coinciden");
        }

        negocio.setNombre(actualizarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(actualizarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(actualizarNegocioDTO.categoriaNegocio());
        negocio.setUbicacion(actualizarNegocioDTO.ubicacion());
        negocio.setListaRutasImagenes(actualizarNegocioDTO.listaImagenesNegocio());
        negocio.setListaTelefonos(actualizarNegocioDTO.listaTelefonos());
        negocio.setListaHorarios(actualizarNegocioDTO.listaHorarios());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);

        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro sino que
        // actualiza el que ya existe
        negocioRepo.save(negocio);
    }
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
    public void aprobarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        if (negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)) {
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }
    @Override
    public DetalleNegocioDTO obtenerNegocioAprobado(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);
        if (negocio.getEstadoRegistro().equals(EstadoRegistro.INACTIVO)){
            throw new Exception("El negocio está inactivo");
        }
        if (!negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)){
            throw  new Exception("El negocio no está aprobado");
        }

        return new DetalleNegocioDTO(
                negocio.getCodigoNegocio(),
                negocio.getCodigoCliente(),
                negocio.getNombre(),
                negocio.getDescripcion(),
                negocio.getCategoriaNegocio(),
                negocio.getEstadoNegocio(),
                negocio.getUbicacion(),
                negocio.getVisitas(),
                negocio.getListaTelefonos(),
                negocio.getListaRutasImagenes(),
                negocio.getListaHorarios(),
                negocio.getEstadoRegistro()
        );
    }

    @Override
    public DetalleNegocioDTO obtenerNegocioRechazado(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);
        if (negocio.getEstadoRegistro().equals(EstadoRegistro.INACTIVO)){
            throw new Exception("El negocio está inactivo");
        }
        if (!negocio.getEstadoNegocio().equals(EstadoNegocio.RECHAZADO)){
            throw  new Exception("El negocio no está rechazado");
        }

        return new DetalleNegocioDTO(
                negocio.getCodigoNegocio(),
                negocio.getCodigoCliente(),
                negocio.getNombre(),
                negocio.getDescripcion(),
                negocio.getCategoriaNegocio(),
                negocio.getEstadoNegocio(),
                negocio.getUbicacion(),
                negocio.getVisitas(),
                negocio.getListaTelefonos(),
                negocio.getListaRutasImagenes(),
                negocio.getListaHorarios(),
                negocio.getEstadoRegistro()
        );
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosFavoritosCliente (String idCliente) throws Exception {
        DetalleClienteDTO detalleClienteDTO = clienteServicio.obtenerCliente(idCliente);
        List<ItemNegocioDTO> listaItemsNegociosFavoritos = new ArrayList<>();
        for (String codigoNegocio: detalleClienteDTO.listaFavoritos()){
            try{
                DetalleNegocioDTO negocio = obtenerNegocioAprobado(codigoNegocio);
                listaItemsNegociosFavoritos.add(new ItemNegocioDTO(
                        negocio.codigoNegocio(),negocio.codigoCliente(),negocio.nombre(),
                        negocio.descripcion(),negocio.categoriaNegocio(),negocio.estadoNegocio(),
                        negocio.ubicacion(),negocio.visitas(),negocio.listaTelefonos(),negocio.listaRutasImagenes(),
                        negocio.listaHorarios(),negocio.estadoRegistro()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return listaItemsNegociosFavoritos;
    }
    @Override
    public List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio) {
        return negocioRepo.findAllByCategoriaNegocioAndEstadoRegistro(categoriaNegocio, EstadoRegistro.ACTIVO);
    }
    @Override
    public List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre) {
        return negocioRepo.findAllByNombreLikeIgnoreCaseAndEstadoRegistro(nombre,EstadoRegistro.ACTIVO);

    }
    @Override
    public List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        return negocioRepo.findAllByEstadoNegocioAndEstadoRegistro(estadoNegocio,EstadoRegistro.ACTIVO);
    }
    @Override
    public List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception {
        return negocioRepo.findAllByCodigoClienteAndEstadoRegistroAndEstadoNegocio(idPropietario, EstadoRegistro.ACTIVO, EstadoNegocio.APROBADO);
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosPropietarioRechazados(String idPropietario) {
        return negocioRepo.findAllByCodigoClienteAndEstadoRegistroAndEstadoNegocio(idPropietario, EstadoRegistro.ACTIVO, EstadoNegocio.RECHAZADO);
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosUbicacion(UbicacionRedondaDTO ubicacionRedondaDTO) {
        double deltaLat = ubicacionRedondaDTO.kmRedonda()/111.32;
        double deltaLon = ubicacionRedondaDTO.kmRedonda() / (111.32 * Math.cos(Math.tanh(ubicacionRedondaDTO.ubicacion().getLatitud())));

        double latitudMinima = ubicacionRedondaDTO.ubicacion().getLatitud() - deltaLat;
        double latitudMaxima = ubicacionRedondaDTO.ubicacion().getLatitud()  + deltaLat;
        double longitudMinima = ubicacionRedondaDTO.ubicacion().getLongitud()  - deltaLon;
        double longitudMaxima = ubicacionRedondaDTO.ubicacion().getLongitud()  + deltaLon;

        return negocioRepo.listarNegociosPorUbicacion(latitudMinima, latitudMaxima, longitudMinima, longitudMaxima, EstadoRegistro.ACTIVO);
    }

    @Override
    public List<ItemNegocioDTO> listarNegociosRecomendados(Ubicacion ubicacion) {
        double deltaLat = 5/111.32;
        double deltaLon = 5/ (111.32 * Math.cos(Math.tanh(ubicacion.getLatitud())));

        double latitudMinima = ubicacion.getLatitud() - deltaLat;
        double latitudMaxima = ubicacion.getLatitud()  + deltaLat;
        double longitudMinima = ubicacion.getLongitud()  - deltaLon;
        double longitudMaxima = ubicacion.getLongitud()  + deltaLon;

        return negocioRepo.listarNegociosRecomendadosZona(latitudMinima,latitudMaxima,longitudMinima,longitudMaxima,EstadoRegistro.ACTIVO);
    }

    //Metodos para verificar existencia de datos
    @Override
    public boolean existeNegocio(String idNegocio) {
        return negocioRepo.findById(idNegocio).isPresent();
    }
    private Negocio obtenerNegocioID(String idNegocio) throws ResourceNotFoundException {

        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if (optionalNegocio.isEmpty()) {
            throw new ResourceNotFoundException(idNegocio);
        }

        return optionalNegocio.get();
    }
    @Override
    public String agregarNegocioFavorito(String idCliente, String idNegocio) throws Exception {
        //Se obtiene el cliente al cual se le va a agregar el negocio favorito
        Cliente cliente = clienteServicio.obtenerClienteID(idCliente);

        /*
        Se arroja una excepción en caso de que no exista el negocio que se quiere
        agregar a los favoritos del cliente
         */
        if (!existeNegocio(idNegocio)) {
            throw new ResourceNotFoundException(idNegocio);
        }
        if (obtenerNegocioAprobado(idNegocio).estadoNegocio() != EstadoNegocio.APROBADO && obtenerNegocioAprobado(idNegocio).estadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("No se puede añadir a favoritos un negocio no aprobado o inactivo");
        }
        if (cliente.getEstadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("Un usuario inactivo no puede agregar negocios a favoritos");
        }
        //En caso de ya estar en la lista de favoritos, se elimina
        if (cliente.getListaNegociosFavoritos().contains(idNegocio)) {
            cliente.getListaNegociosFavoritos().remove(idNegocio);
        }
        //En caso contrario, se quita de la lista
        else {
            cliente.getListaNegociosFavoritos().add(idNegocio);
        }

        //Se actualiza la información del cliente en el repositorio
        clienteServicio.actualizarFavoritos(cliente);

        //Se retorna el código del negocio para verificar en los tests
        return idNegocio;

    }

}
