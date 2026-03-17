package prestamoescolar.modelo;

import java.sql.Date;
import java.util.Calendar;

public class LargaDuracion extends Prestamos {

	LargaDuracion(int duracionMaxima, boolean[] condicionesRenovacion, boolean[] restriccionesUso, Date fechaInicio,
			Date fechaFinal, boolean activo,Persona persona,MaterialEscolar materialEscolar) {
		super(duracionMaxima,condicionesRenovacion,restriccionesUso,fechaInicio,fechaFinal,activo,persona,materialEscolar);
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
	
	public Date calcularFechaFinal(Date fechaInicio, int duracionMaxima) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(fechaInicio);
	    cal.add(Calendar.DAY_OF_MONTH, duracionMaxima);
	    Date nuevaFecha = new Date(cal.getTimeInMillis());
	    if (fechaFinal.after(nuevaFecha)) {
	        this.fechaFinal = nuevaFecha;
	    }
	    return fechaFinal;
	}

}
