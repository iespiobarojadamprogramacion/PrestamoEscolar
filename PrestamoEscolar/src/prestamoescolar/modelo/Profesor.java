package prestamoescolar.modelo;

public class Profesor extends Persona {
	private int codigoProfesor;
	
		public Profesor(String nombre, String apellido, int telefono, Prestamos prestamo,int codigoProfesor) {
			super(nombre,apellido,telefono,prestamo);
			this.codigoProfesor=codigoProfesor;
			
		}

		public int getCodigoProfesor() {
			return codigoProfesor;
		}

		public void setCodigoProfesor(int codigoProfesor) {
			this.codigoProfesor = codigoProfesor;
		}

		public String toString() {
			return super.toString()+"Es un profesor con codigo de profesor: "+codigoProfesor;
		}
}