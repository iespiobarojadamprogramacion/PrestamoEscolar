package prestamoescolar.modelo;

public class Alumno extends Persona{
	private String curso;
	
		public Alumno(String nombre, String apellido, int telefono, Prestamos prestamo ,String curso) {
			super(nombre,apellido,telefono,prestamo);
			this.curso=curso;
			
		}

		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public String toString() {
			return super.toString()+"Es un alumno del curso:"+curso;
		}
}