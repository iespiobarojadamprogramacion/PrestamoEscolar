package prestamoescolar.modelo;
/**
 Clase Profesor que hereda de Persona.
 Representa a un profesor dentro del sistema de préstamo escolar.
 Añade un código único de identificación del profesor.
 */

public class Profesor extends Persona {
	private int codigoProfesor;
	
		public Profesor(String nombre, String apellido, int telefono,int codigoProfesor) {
			super(nombre,apellido,telefono);
			this.codigoProfesor=codigoProfesor;
			
		}

		public int getCodigoProfesor() {
			return codigoProfesor;
		}

		public void setCodigoProfesor(int codigoProfesor) {
			this.codigoProfesor = codigoProfesor;
		}

		public String toString() {
			return super.toString()+" Es un profesor con codigo de profesor: "+codigoProfesor;
		}
}