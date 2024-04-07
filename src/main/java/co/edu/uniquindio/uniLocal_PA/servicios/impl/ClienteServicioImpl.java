package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.ActualizarClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.CambioPasswordDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.RegistroClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.InicioSesionClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServicioImpl implements ClienteServicio {
    @Override
    public void registrarse(RegistroClienteDTO registroClienteDTO) throws Exception {

    }

    @Override
    public void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception {

    }

    @Override
    public void eliminarCuenta(String idCuenta) throws Exception {

    }

    @Override
    public void iniciarSesion(InicioSesionClienteDTO inicioSesionClienteDTO) throws Exception {

    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }
}
