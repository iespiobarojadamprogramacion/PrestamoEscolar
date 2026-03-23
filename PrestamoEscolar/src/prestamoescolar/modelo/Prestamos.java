package prestamoescolar.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public abstract class Prestamos {

    protected Persona persona;
    protected MaterialEscolar materialEscolar;
    protected Date fechaInicio;
    protected Date fechaFinal;
    protected int duracionMaxima;
    protected boolean[] restriccionesUso;
    protected boolean activo=true;

    public static ArrayList<Prestamos> prestamos = new ArrayList<>();

    public Prestamos(Persona persona, MaterialEscolar materialEscolar, Date fechaInicio) {
        this.persona = persona;
        this.materialEscolar = materialEscolar;
        this.fechaInicio = fechaInicio;
    }

    // 🔥 MÉTODO COMÚN (SOLO AQUÍ)
    public Date calcularFechaFinal() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fechaInicio);
        cal.add(Calendar.DAY_OF_MONTH, this.duracionMaxima);

        this.fechaFinal = new Date(cal.getTimeInMillis());
        return this.fechaFinal;
    }
    
    public void revisarFechaActual(Date fechaActual) {
        if (activo && fechaActual.after(fechaFinal)) {
            activo = false; 
            materialEscolar.setEstado(MaterialEscolar.EstadoMaterial.EN_MANTENIMIENTO);
            materialEscolar.setDiasMantenimiento(2); // 2 días de mantenimiento
        }
    }

    // GETTERS
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public MaterialEscolar getMaterialEscolar() {
        return materialEscolar;
    }
    
    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public String toString() {
        String info = "Préstamo de: " + materialEscolar.getNombre() +
                      " | Persona: " + persona.getNombre() + " " + persona.getApellido();

        // Añadir curso o código según tipo de persona
        if (persona instanceof Alumno) {
            info += " | Curso: " + ((Alumno) persona).getCurso();
        } else if (persona instanceof Profesor) {
            info += " | Código profesor: " + ((Profesor) persona).getCodigoProfesor();
        }

        info += " | Fecha inicio: " + fechaInicio +
                " | Fecha devolución: " + fechaFinal;

        // Días restantes
        if (activo) {
            long diasRestantes = (fechaFinal.getTime() - fechaInicio.getTime()) / (1000*60*60*24);
            info += " | Días restantes: " + diasRestantes;
        }

        info += " | Activo: " + (activo ? "Sí" : "No");

        return info;
    }

	public Persona getPersona() {
        return persona;
    }

	public java.util.Date getFechaInicio() {
        return fechaInicio;
    }

}

