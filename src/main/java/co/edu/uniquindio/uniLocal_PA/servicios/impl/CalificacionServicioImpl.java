package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente;
import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal_PA.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal_PA.repositorios.CalificacionRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.ClienteRepo;
import co.edu.uniquindio.uniLocal_PA.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.CalificacionServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CalificacionServicioImpl implements CalificacionServicio {
    private final CalificacionRepo calificacionRepo;
    private final NegocioRepo negocioRepo;
    private final ClienteRepo clienteRepo;

    public CalificacionServicioImpl(CalificacionRepo calificacionRepo, NegocioRepo negocioRepo, ClienteRepo clienteRepo) {
        this.calificacionRepo = calificacionRepo;
        this.negocioRepo = negocioRepo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    public String agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception {
        Negocio negocio = obtenerNegocioID(agregarCalificacionDTO.codigoNegocio());
        Cliente cliente = obtenerClienteID(agregarCalificacionDTO.codigoCliente());
        //Se crea la calificación
        Calificacion calificacion = new Calificacion();

        //Se asignan sus datos
        calificacion.setCodigoCliente( agregarCalificacionDTO.codigoCliente() );
        calificacion.setCodigoNegocio( agregarCalificacionDTO.codigoNegocio() );
        calificacion.setFecha( agregarCalificacionDTO.fecha() );
        calificacion.setValoracion( agregarCalificacionDTO.valoracion() );
        calificacion.setMensaje( agregarCalificacionDTO.mensaje() );

        //Se agrega a la base de datos
        Calificacion calificacionGuardada = calificacionRepo.save(calificacion);

        negocio.getListaCalificaciones().add(calificacionGuardada.getCodigoCalificacion());
        cliente.getListaCalificaciones().add(calificacionGuardada.getCodigoCalificacion());

        negocioRepo.save(negocio);
        clienteRepo.save(cliente);

        //Se obtiene el codigo de la calificación para verificar su funcionamiento
        return calificacion.getCodigoCalificacion();
    }

    @Override
    public void actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception {

        Calificacion calificacion = obtenerCalificacionID(actualizarCalificacionDTO.idCalificacion());

        //Se actualizan la valoración y el mensaje
        calificacion.setValoracion( actualizarCalificacionDTO.valoracion() );
        calificacion.setMensaje( actualizarCalificacionDTO.mensaje() );

        //Se actualiza la calificación en la base de datos
        calificacionRepo.save(calificacion);
    }

    @Override
    public List<ItemCalificacionDTO> listarCalificacionesNegocio(String idNegocio) throws ResourceNotFoundException {
        Negocio negocio = obtenerNegocioID(idNegocio);

        List<ItemCalificacionDTO> items = new ArrayList<>();

        for (String calificacionID: negocio.getListaCalificaciones()){
            Calificacion calificacion = obtenerCalificacionID(calificacionID);

            items.add(new ItemCalificacionDTO(calificacion.getCodigoCliente(), calificacion.getCodigoNegocio(),
                    calificacion.getCodigoCliente(), calificacion.getFecha(),calificacion.getValoracion(),
                    calificacion.getMensaje(), calificacion.getRespuesta()));
        }
        return items;
    }

    @Override
    public void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {
        Calificacion calificacion = obtenerCalificacionID(responderCalificacionDTO.idCalificacion());

        calificacion.setRespuesta(responderCalificacionDTO.respuesta());

        calificacionRepo.save(calificacion);
    }

    @Override
    public float obtenerCalificacionPromedioNegocio(List<ItemCalificacionDTO> listaItemCalificacionDTO) {
        List<Calificacion> listaCalificaciones = calificacionRepo.findAll();
        float promedio = 0;
        for (Calificacion calificacion: listaCalificaciones){
            promedio+=calificacion.getValoracion();
        }
        return (promedio == 0) ? 0: promedio/listaCalificaciones.size();
    }

    private Cliente obtenerClienteID(String idCliente) throws ResourceNotFoundException {

        Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);

        if (optionalCliente.isEmpty()){
            throw new ResourceNotFoundException(idCliente);
        }

        return optionalCliente.get();
    }
    private Negocio obtenerNegocioID(String idNegocio) throws ResourceNotFoundException {

        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if (optionalNegocio.isEmpty()){
            throw new ResourceNotFoundException(idNegocio);
        }

        return optionalNegocio.get();
    }
    private Calificacion obtenerCalificacionID(String idCalificacion) throws ResourceNotFoundException {

        Optional<Calificacion> optionalCalificacion = calificacionRepo.findById(idCalificacion);

        if (optionalCalificacion.isEmpty()){
            throw new ResourceNotFoundException(idCalificacion);
        }

        return optionalCalificacion.get();
    }
    private boolean existeCliente(String idCliente) {
        return clienteRepo.findById(idCliente).isPresent();
    }
}
