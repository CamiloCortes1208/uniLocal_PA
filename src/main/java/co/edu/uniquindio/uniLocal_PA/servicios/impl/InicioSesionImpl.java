package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.dto.clienteDTO.LoginClienteDTO;
import co.edu.uniquindio.uniLocal_PA.dto.moderadorDTO.LoginModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.InicioSesionServicio;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@NoArgsConstructor

public class InicioSesionImpl implements InicioSesionServicio {
    @Override
    public void inicioSesionCliente(LoginClienteDTO loginClienteDTO) {

    }

    @Override
    public void inicioSesionModerador(LoginModeradorDTO loginModeradorDTO) {

    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }
}
