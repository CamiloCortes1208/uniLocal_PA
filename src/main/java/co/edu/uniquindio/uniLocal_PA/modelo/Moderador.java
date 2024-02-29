package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("moderadores")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Moderador extends Cuenta{
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String nombre, String fotoPerfil, String password, String email, EstadoRegistro estadoRegistro) {
        super(nombre, fotoPerfil, password, email, estadoRegistro);
    }
}
