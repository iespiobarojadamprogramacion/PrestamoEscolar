package prestamoescolar.modelo;

public class Profesor {
	private int codigoProfesor;
	
		public Profesor(String nombre, String apellido, int telefono, int codigoProfesor) {
			super();
			this.codigoProfesor=codigoProfesor;
			
		}

		public int getCodigoProfesor() {
			return codigoProfesor;
		}

		public void setCodigoProfesor(int codigoProfesor) {
			this.codigoProfesor = codigoProfesor;
		}
		
		

}
