package co.edu.uniquindio.uniLocal_PA.modelo.documentos;

import co.edu.uniquindio.uniLocal_PA.modelo.Comentario;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("calificaciones")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Calificacion extends Comentario {
    @Id
    @EqualsAndHashCode.Include
    private String codigoCalificacion;

    private String codigoNegocio;
    private int valoracion;
    private String respuesta;

    public Calificacion(String codigoCliente, LocalDateTime fecha, String mensaje,
                        String codigoCalificacion, String codigoNegocio, int valoracion,
                        String respuesta) {
        super(codigoCliente, fecha, mensaje);
        this.codigoCalificacion = codigoCalificacion;
        this.codigoNegocio = codigoNegocio;
        this.valoracion = valoracion;
        this.respuesta = respuesta;
    }
}
