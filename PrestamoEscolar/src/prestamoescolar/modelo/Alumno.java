package prestamoescolar.modelo;

public class Alumno extends Persona{
	private String curso;
	
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
		
		@Override
		public String toString() {
			return super.toString()+" Es un alumno del curso:"+curso;
		}
}