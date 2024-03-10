package co.edu.uniquindio.uniLocal_PA.servicios.interfaces;

import co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio;

import java.util.List;

public interface NegocioServicio {

    void crearNegocio();

    void actualizarNegocio();

    void eliminarNegocio(String idNegocio);

    List<Negocio> buscarNegocios();

    List<Negocio> filtrarPorEstado();

    List<Negocio> listarNegociosPropietario();

    void cambiarEstado();

    void registrarRevision();

}