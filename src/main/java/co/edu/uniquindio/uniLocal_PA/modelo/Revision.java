package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Revision {
    private LocalDateTime fecha;
    private String codigoModerador;
    private String descripcion;
    private EstadoNegocio estadoNegocio;
}
