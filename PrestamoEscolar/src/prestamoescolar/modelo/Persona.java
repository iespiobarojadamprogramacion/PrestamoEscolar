package prestamoescolar.modelo;

import java.util.ArrayList;

/**
 * Clase abstracta que representa una persona del centro educativo.
 */
public abstract class Persona {

    public static ArrayList<Persona> personas = new ArrayList<>();

    private String nombre;
    private String apellido;
    private int telefono;

    public Persona(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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
        return "La persona con nombre: " + nombre + " y apellido: " + apellido + " con telefono: " + telefono;
    }
}