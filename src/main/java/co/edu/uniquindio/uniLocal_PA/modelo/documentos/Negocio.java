package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import co.edu.uniquindio.uniLocal_PA.modelo.Horario;
import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal_PA.modelo.Ubicacion;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("negocios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Negocio {
    @Id
    @EqualsAndHashCode.Include
    private String codigoNegocio;

    private String codigoCliente;
    private String nombre;
    private String descripcion;
    private CategoriaNegocio categoriaNegocio;
    private Ubicacion ubicacion;
    private List<String> listaTelefonos = new ArrayList<>();
    private List<String> listaRutasImagenes = new ArrayList<>();
    private List<Horario> listaHorarios = new ArrayList<>();
    private List<Calificacion> listaCalificaciones = new ArrayList<>();
    private List<Revision> listaRevisiones = new ArrayList<>();

}
