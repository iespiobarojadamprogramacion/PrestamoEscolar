package prestamoescolar.modelo;

import java.sql.Date;
import java.util.Calendar;

public class CortaDuracion extends Prestamos {

	CortaDuracion(Persona persona,MaterialEscolar materialEscolar,Date fechaInicio) {
		super(persona,materialEscolar,fechaInicio);
	}
	
	public void setDuracionMaxima(int duracionMaxima) {
		this.duracionMaxima=duracionMaxima;
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
