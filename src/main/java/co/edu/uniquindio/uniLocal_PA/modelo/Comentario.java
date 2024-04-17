package co.edu.uniquindio.uniLocal_PA.modelo;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {
    private String codigoCliente;
    private LocalDateTime fecha;
    private String mensaje;
}
