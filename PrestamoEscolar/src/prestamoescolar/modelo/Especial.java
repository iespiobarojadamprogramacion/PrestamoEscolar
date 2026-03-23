package prestamoescolar.modelo;

import java.sql.Date;

public class Especial extends Prestamos {

    public Especial(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        super(persona, materialEscolar, fechaInicio);

        this.duracionMaxima = 15;
        this.restriccionesUso = new boolean[]{true, true};
        calcularFechaFinal();
    }
}
