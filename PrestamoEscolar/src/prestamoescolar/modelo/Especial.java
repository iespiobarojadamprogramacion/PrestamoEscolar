package prestamoescolar.modelo;

import java.sql.Date;

public class Especial extends Prestamos {

	Especial(int duracionMaxima, boolean[] condicionesRenovacion, boolean[] restriccionesUso, Date fechaInicio,
			Date fechaFinal, boolean activo) {
		super(duracionMaxima, condicionesRenovacion, restriccionesUso, fechaInicio, fechaFinal, activo);
	}
	
	public void setDuracionMaxima(int duracionMaxima) {
		this.duracionMaxima=duracionMaxima;
	}
	
	public void setCondicionesRenovacion(boolean[] condicionesRenovacion) {
		this.condicionesRenovacion=condicionesRenovacion;
	}
	
	public void setRestriccionesUso(boolean[] restriccionesUso) {
		this.restriccionesUso=restriccionesUso;
	}

}
