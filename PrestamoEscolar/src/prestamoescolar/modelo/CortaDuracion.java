package prestamoescolar.modelo;

import java.sql.Date;

public class CortaDuracion extends Prestamos {

    public CortaDuracion(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        super(persona, materialEscolar, fechaInicio);

        this.duracionMaxima = 7;
        this.restriccionesUso = new boolean[]{true, false}; // ejemplo
        calcularFechaFinal();
    }
}
