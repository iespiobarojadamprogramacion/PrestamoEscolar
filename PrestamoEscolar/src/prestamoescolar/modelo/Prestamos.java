package prestamoescolar.modelo;

import java.sql.Date;
import java.util.Arrays;

public abstract class Prestamos {
	public int duracionMaxima;
	public boolean[] condicionesRenovacion;
	public boolean[] restriccionesUso;
	private Date fechaInicio;
	public Date fechaFinal;
	private boolean activo;
	
	Prestamos(int duracionMaxima,boolean[] condicionesRenovacion,boolean[] restriccionesUso,
			Date fechaInicio,Date fechaFinal,boolean activo){
		this.duracionMaxima=duracionMaxima;
		this.condicionesRenovacion=condicionesRenovacion;
		this.restriccionesUso=restriccionesUso;
		this.fechaInicio=fechaInicio;
		this.fechaFinal=fechaFinal;
		this.activo=activo;
	}
	
	public int getDuracionMaxima() {
		return duracionMaxima;
	}
	
	public boolean[] getCondicionesRenovacion() {
		return condicionesRenovacion;
	}
	
	public boolean[] getRestriccionesUso() {
		return restriccionesUso;
	}
	
	public Date getFechainicio() {
		return fechaInicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechaInicio = fechainicio;
	}
	public Date getFechafinal() {
		return fechaFinal;
	}
	public void setFechafinal(Date fechafinal) {
		this.fechaFinal = fechafinal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String toString() {
		return "Prestamos [duracionMaxima=" + duracionMaxima + ", condicionesRenovacion="
				+ Arrays.toString(condicionesRenovacion) + ", restriccionesUso=" + Arrays.toString(restriccionesUso)
				+ ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", activo=" + activo + "]";
	}
	
}
