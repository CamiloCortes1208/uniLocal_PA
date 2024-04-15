package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import co.edu.uniquindio.uniLocal_PA.modelo.Comentario;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("opiniones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Opinion extends Comentario {
    @Id
    @EqualsAndHashCode.Include
    private String codigoOpinion;
    private String codigoPublicacion;
    private List<String> listaMeGustas = new ArrayList<>();

    public Opinion(String codigoCliente, LocalDateTime fecha, String mensaje, String codigoOpinion) {
        super(codigoCliente, fecha, mensaje);
        this.codigoOpinion = codigoOpinion;
    }
}
