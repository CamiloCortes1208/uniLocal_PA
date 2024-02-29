package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("negocios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Negocio {
    @Id
    private String codigo;
    private String nombre;
    private String descripcion;
    private List<String> listaTelefonos;
    private CategoriaNegocio categoriaNegocio;
    private List<String> listaRutasImagenes;
    private Ubicacion ubicacion;

}
