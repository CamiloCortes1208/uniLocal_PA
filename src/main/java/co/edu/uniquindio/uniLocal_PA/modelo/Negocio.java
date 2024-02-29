package co.edu.uniquindio.uniLocal_PA.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("negocios")
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
