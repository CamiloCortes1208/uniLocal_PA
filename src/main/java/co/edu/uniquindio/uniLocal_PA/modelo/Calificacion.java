package co.edu.uniquindio.uniLocal_PA.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("calificaciones")
public class Calificacion {
    @Id
    private String codigo;
    private LocalDateTime fecha;
    private int valoracion;
    private String codigoCliente;
    private String codigoNegocio;
    private String mensaje;
    private String respuesta;
}
