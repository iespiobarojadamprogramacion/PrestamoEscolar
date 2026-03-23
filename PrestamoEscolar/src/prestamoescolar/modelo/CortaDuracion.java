package prestamoescolar.modelo;

import java.sql.Date;
/**
 Clase CortaDuracion que hereda de Prestamos,
 Representa un préstamo de material escolar con una duración corta (máximo 7 días).
 Define restricciones específicas de uso para este tipo de préstamo.
 */

public class CortaDuracion extends Prestamos {

    public CortaDuracion(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        super(persona, materialEscolar, fechaInicio);

        this.duracionMaxima = 7;
     // restriccionesUso[0] = uso en aula (true = permitido)
     // restriccionesUso[1] = salida del centro (false = no permitido)
        this.restriccionesUso = new boolean[]{true, false};
        calcularFechaFinal();
    }
}
