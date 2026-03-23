package prestamoescolar.modelo;

public class Alumno extends Persona{
	private String curso;
	/**
	  Clase Alumno que hereda de Persona,
	  Representa a un alumno dentro del sistema de préstamo escolar.
	  Añade el atributo curso para identificar en qué curso está el alumno.
	 */
	
		public Alumno(String nombre, String apellido, int telefono,String curso) {
			super(nombre,apellido,telefono);
			this.curso=curso;
			
		}

		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public String toString() {
			return super.toString()+" Es un alumno del curso:"+curso;
		}
}