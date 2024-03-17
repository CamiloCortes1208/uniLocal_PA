package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.negocioDTO.RegistrarRevisionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.NegocioServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void eliminarNegocio(String idNegocio) {

    }

    @Override
    public List<Negocio> buscarNegocios(String categoria, Ubicacion ubicacion) {
        return null;
    }

    @Override
    public List<Negocio> filtrarPorEstado(EstadoNegocio estadoNegocio) {
        return null;
    }

    @Override
    public List<Negocio> listarNegociosPropietario(String idPropietario) throws Exception {
        return null;
    }

    @Override
    public void cambiarEstado(EstadoNegocio estadoNegocio) {

    }

    @Override
    public void registrarRevision(RegistrarRevisionDTO registrarRevisionDTO) throws Exception {

    }
}
