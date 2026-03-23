package prestamoescolar.modelo;

import java.sql.Date;
import java.util.Arrays;

/**
 * Clase abstracta que representa un préstamo de material escolar.
 */
public abstract class Prestamos {
    public int duracionMaxima;
    public boolean[] restriccionesUso;
    private Date fechaInicio;
    public Date fechaFinal;
    private boolean activo;
    private Persona persona;
    private MaterialEscolar materialEscolar;
    

    protected Prestamos(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        this.persona = persona;
        this.materialEscolar = materialEscolar;
        this.fechaInicio = fechaInicio;
        this.activo = true; 
    }

    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public boolean[] getRestriccionesUso() {
        return restriccionesUso;
    }

    public Date getFechainicio() {
        return fechaInicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechaInicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechaFinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechaFinal = fechafinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public MaterialEscolar getMaterialEscolar() {
        return materialEscolar;
    }

    public void setMaterialEscolar(MaterialEscolar materialEscolar) {
        this.materialEscolar = materialEscolar;
    }

    @Override
    public String toString() {
        return "Prestamo de " + persona.getNombre() + " " + persona.getApellido() +
               " sobre material " + materialEscolar.getCodigo() + " (" + materialEscolar.getTipo() + ")" +
               ", duración máxima: " + duracionMaxima + " días" +
               ", restricciones: " + Arrays.toString(restriccionesUso) +
               ", inicio: " + fechaInicio +
               ", fin: " + fechaFinal +
               ", activo: " + activo;
    }

}
