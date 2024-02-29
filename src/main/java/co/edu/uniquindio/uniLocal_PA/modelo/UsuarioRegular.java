package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("usuariosRegulares")
@Getter
@Setter
@ToString
public class UsuarioRegular extends Cuenta{
    @Id
    private String codigo;
    private String nickname;
    private String ciudadResidencia;

    public UsuarioRegular(String nombre, String fotoPerfil, String password, String email, EstadoRegistro estadoRegistro) {
        super(nombre, fotoPerfil, password, email, estadoRegistro);
    }
}
