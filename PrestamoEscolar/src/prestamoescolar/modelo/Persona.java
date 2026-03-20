package prestamoescolar.modelo;
import java.util.ArrayList;

public class Persona {
	
	public static ArrayList<Persona> personas=new ArrayList<>();
	
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

		public String toString() {
			return "La persona con nombre: "+nombre+" y apellido: "+apellido+" con telefono: "+telefono;
		}
}