package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("opiniones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Opinion {
    @Id
    @EqualsAndHashCode.Include
    private String codigoOpinion;

    private String codigoCalificacion;
    private List<Opinion> listaRespuestas = new ArrayList<>();
}
