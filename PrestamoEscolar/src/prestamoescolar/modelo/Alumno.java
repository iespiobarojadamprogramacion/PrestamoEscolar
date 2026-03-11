package prestamoescolar.modelo;

public class Alumno {
	private String curso;
	
		public Alumno(String nombre, String apellido, int telefono, String curso) {
			super();
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
			return "Alumno [curso=" + curso + ", getCurso()=" + getCurso() + "]";
		}
		
		

}
