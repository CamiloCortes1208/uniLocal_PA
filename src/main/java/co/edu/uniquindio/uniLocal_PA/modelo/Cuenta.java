package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Cuenta {
    private String nombre;
    private String fotoPerfil;
    private String password;
    private String email;
    private EstadoRegistro estadoRegistro;

}
