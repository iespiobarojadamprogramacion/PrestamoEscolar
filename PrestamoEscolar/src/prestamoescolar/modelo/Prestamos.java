package prestamoescolar.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Prestamos {
	public int duracionMaxima;
	public boolean[] restriccionesUso;
	private Date fechaInicio;
	public Date fechaFinal;
	private boolean activo;
	private Persona persona;
	private MaterialEscolar materialEscolar;
	
	Prestamos(Persona persona,MaterialEscolar materialEscolar,Date fechaInicio){
		
		this.persona=persona;
		this.materialEscolar=materialEscolar;
		this.fechaInicio=fechaInicio;

	}
	
//	Prestamos(int duracionMaxima,boolean[] condicionesRenovacion,boolean[] restriccionesUso,
	//		Date fechaInicio,Date fechaFinal,boolean activo,Persona persona,MaterialEscolar materialEscolar){
		//this.duracionMaxima=duracionMaxima;
		//this.condicionesRenovacion=condicionesRenovacion;
		//this.restriccionesUso=restriccionesUso;
		//this.fechaInicio=fechaInicio;
		//this.fechaFinal=fechaFinal;
		//this.activo=activo;
		//this.persona=persona;
		//this.materialEscolar=materialEscolar;
	//}
	
	public int getDuracionMaxima() {
		return duracionMaxima;
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
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public MaterialEscolar getMaterialEscolar() {
		return materialEscolar;
	}

	public void setMaterialEscolar(MaterialEscolar materialEscolar) {
		this.materialEscolar = materialEscolar;
	}

	public String toString() {
		return "El Prestamo tiene una duracion maxima de: " + duracionMaxima + " dias, sus condiciones de renovacion son: "
				 + ", sus restricciones de uso son:" + Arrays.toString(restriccionesUso)
				+ " , el prestamo inicio el dia: " + fechaInicio + " y finaliza el dia: " + fechaFinal + " ¿y esta activo.?" + activo;
	}
	
}