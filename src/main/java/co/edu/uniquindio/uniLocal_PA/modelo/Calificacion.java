package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("calificaciones")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calificacion {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private LocalDateTime fecha;
    private int valoracion;
    private String codigoCliente;
    private String codigoNegocio;
    private String mensaje;
    private String respuesta;
}
