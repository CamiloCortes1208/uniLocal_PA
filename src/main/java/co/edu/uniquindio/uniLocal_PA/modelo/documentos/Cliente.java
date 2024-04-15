package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import co.edu.uniquindio.uniLocal_PA.modelo.Cuenta;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoRegistro;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("clientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Cliente extends Cuenta {
    @Id
    private String codigoCliente;

    private String nickname;
    private String ciudadResidencia;
    private List<String> listaPublicaciones = new ArrayList<>();
    private List<String> listaOpiniones = new ArrayList<>();
    private List<String> listaCalificaciones = new ArrayList<>();
    private List<String> listaNegocios = new ArrayList<>();
    private List<String> listaNegociosFavoritos = new ArrayList<>();
    private List<String> listaPublicacionesFavoritas = new ArrayList<>();

    public Cliente(String nombre, String fotoPerfil, String password, String email,
                   EstadoRegistro estadoRegistro, String codigoCliente, String nickname,
                   String ciudadResidencia) {
        super(nombre, fotoPerfil, password, email, estadoRegistro);
        this.codigoCliente = codigoCliente;
        this.nickname = nickname;
        this.ciudadResidencia = ciudadResidencia;
    }
}
