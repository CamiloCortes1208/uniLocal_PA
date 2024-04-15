package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
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
    private int cantidadMeGusta = 0;
    private String rutaImagen;
    private List<String> listaOpiniones = new ArrayList<>();
    private LocalDateTime fechaPublicacion;
}
