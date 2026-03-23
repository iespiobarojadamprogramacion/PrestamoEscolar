package prestamoescolar.modelo;
import java.util.ArrayList;

public class Persona {
	/**
	 Clase Persona.
	 Representa a una persona dentro del sistema de préstamo escolar.
	 Puede ser un alumno o un profesor (clases que heredarán de esta).
	 */

    // Lista global que almacena todas las personas del sistema.
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