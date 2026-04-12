package prestamoescolar.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase abstracta Prestamos. Representa un préstamo de material escolar
 * realizado por una persona.
 * 
 * Esta clase contiene la lógica común de todos los tipos de préstamo (como
 * corta duración o especial), y será heredada por dichas clases.
 */

public abstract class TiposDePrestamo {

	protected Persona persona;
	protected MaterialEscolar materialEscolar;
	protected Date fechaInicio;
	protected Date fechaFinal;
	protected int duracionMaxima;
	protected boolean[] restriccionesUso;
	protected boolean activo = true;

	/**
	 * Lista global de todos los préstamos realizados en el sistema.
	 */
	public static ArrayList<TiposDePrestamo> prestamos = new ArrayList<>();

	public TiposDePrestamo(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
		this.persona = persona;
		this.materialEscolar = materialEscolar;
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Calcula la fecha final del préstamo sumando la duración máxima a la fecha de
	 * inicio.
	 */
	public Date calcularFechaFinal() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.fechaInicio);
		cal.add(Calendar.DAY_OF_MONTH, this.duracionMaxima);

		this.fechaFinal = new Date(cal.getTimeInMillis());
		return this.fechaFinal;
	}

	/**
	 * Revisa si el préstamo ha superado la fecha límite. Si se pasa: - Se marca
	 * como inactivo - El material pasa a mantenimiento
	 */
	public void revisarFechaActual(Date fechaActual) {
		if (activo && fechaActual.after(fechaFinal)) {
			activo = false;
			materialEscolar.setEstado(Estado_Material.En_mantenimiento);
			materialEscolar.setDiasMantenimiento(2);
		}
	}

	// GETTERS

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public MaterialEscolar getMaterialEscolar() {
		return materialEscolar;
	}

	public int getDuracionMaxima() {
		return duracionMaxima;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public Persona getPersona() {
		return persona;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public int diasRestantes(Date fechaActual) {
		long diferencia = fechaFinal.getTime() - fechaActual.getTime();
		return (int) (diferencia / (1000 * 60 * 60 * 24));
	}

	@Override
	public String toString() {

		String info = "Material: " + materialEscolar.getTipo();
		info += " | Persona: " + persona.getNombre() + " " + persona.getApellido();

		if (persona instanceof Alumno) {
			info += " | Curso: " + ((Alumno) persona).getCurso();
		} else if (persona instanceof Profesor) {
			info += " | Codigo: " + ((Profesor) persona).getCodigoProfesor();
		}

		info += " | Inicio: " + formatearFecha(fechaInicio);
		info += " | Fin: " + formatearFecha(fechaFinal);
		info += " | Activo: " + (activo ? "Si" : "No");

		return info;
	}

	private String formatearFecha(Date fecha) {
		int dia = fecha.getDate();
		int mes = fecha.getMonth() + 1; // getMonth() devuelve 0-11
		int anio = fecha.getYear() + 1900;
		return String.format("%02d-%02d-%04d", dia, mes, anio);
	}
}
