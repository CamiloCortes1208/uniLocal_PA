package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("publicaciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publicacion {
    @Id
    @EqualsAndHashCode.Include
    private String codigoPublicacion;

    private String codigoCliente;
    private String descripcion;
    private int cantidadMeGusta;
    private List<String> listaRutasImagenes = new ArrayList<>();
    private List<Opinion> listaOpiniones = new ArrayList<>();
}
