package co.edu.uniquindio.uniLocal_PA.modelo;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cuenta {
    private String nombre;
    private String fotoPerfil;
    private String password;
    private String email;
    private EstadoRegistro estadoRegistro;

}
