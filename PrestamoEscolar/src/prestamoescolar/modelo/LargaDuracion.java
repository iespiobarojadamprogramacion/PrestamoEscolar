package prestamoescolar.modelo;

import java.sql.Date;

public class LargaDuracion extends Prestamos {

    public LargaDuracion(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        super(persona, materialEscolar, fechaInicio);

        this.duracionMaxima = 30;
        this.restriccionesUso = new boolean[]{false, false};
        calcularFechaFinal();
    }
}
