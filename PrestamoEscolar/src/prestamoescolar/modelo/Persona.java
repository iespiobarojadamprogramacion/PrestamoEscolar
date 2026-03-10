package prestamoescolar.modelo;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int telefono;
	
		public Persona(String nombre, String apellido, int telefono) {
			this.apellido=apellido;
			this.nombre=nombre;
			this.telefono=telefono;
			
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

		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
		}
		
		
		
				

}
