package prestamoescolar.modelo;

/**
 * Clase que representa a un profesor del centro educativo.
 */
public class Profesor extends Persona {
    private int codigoProfesor;

    public Profesor(String nombre, String apellido, int telefono, int codigoProfesor) {
        super(nombre, apellido, telefono);
        this.codigoProfesor = codigoProfesor;
    }

    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    @Override
    public String toString() {
        return super.toString() + " Es un profesor con codigo de profesor: " + codigoProfesor;
    }
}