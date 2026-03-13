package prestamoescolar.modelo;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int telefono;
	private Prestamos prestamo;

		public Persona(String nombre, String apellido, int telefono,Prestamos prestamo) {
			this.apellido=apellido;
			this.nombre=nombre;
			this.telefono=telefono;
			this.prestamo=prestamo;
		}

		public String getNombre() {
			return nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public int getTelefono() {
			return telefono;
		}

		public String toString() {
			return "El prestamo: "+prestamo+" Pertenece a la persona con nombre: " + nombre + " y apellido: " + apellido + " con el telefono:" + telefono+" - ";
		}
}