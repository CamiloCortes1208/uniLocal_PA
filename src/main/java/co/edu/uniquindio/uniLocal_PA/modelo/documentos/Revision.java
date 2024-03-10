package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import co.edu.uniquindio.uniLocal_PA.modelo.enumeraciones.EstadoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("revisiones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Revision {
    @Id
    @EqualsAndHashCode.Include
    private String codigoRevision;

    private LocalDateTime fecha;
    private String codigoModerador;
    private String descripcion;
    private EstadoNegocio estadoNegocio;
}
