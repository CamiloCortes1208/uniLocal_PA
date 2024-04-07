package co.edu.uniquindio.uniLocal_PA.servicios.impl;

import co.edu.uniquindio.uniLocal_PA.servicios.dto.clienteDTO.InicioSesionClienteDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.dto.moderadorDTO.InicioSesionModeradorDTO;
import co.edu.uniquindio.uniLocal_PA.servicios.interfaces.InicioSesionServicio;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@NoArgsConstructor

public class InicioSesionImpl implements InicioSesionServicio {
    @Override
    public void inicioSesionCliente(InicioSesionClienteDTO inicioSesionClienteDTO) {
        
    }

    @Override
    public void inicioSesionModerador(InicioSesionModeradorDTO inicioSesionModeradorDTO) {

    }
}