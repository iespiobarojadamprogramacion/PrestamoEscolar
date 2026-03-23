package prestamoescolar.modelo;

import java.util.ArrayList;

public class MaterialEscolar {

    // ENUM DE ESTADO DEL MATERIAL
    public enum EstadoMaterial {
        DISPONIBLE,
        EN_PRESTAMO,
        EN_MANTENIMIENTO
    }

    private String nombre; // nombre o descripción del material
    private EstadoMaterial estado = EstadoMaterial.DISPONIBLE;
    private int diasMantenimiento = 0;

    // LISTA GLOBAL DE MATERIALES
    public static ArrayList<MaterialEscolar> materiales = new ArrayList<>();

    // CONSTRUCTOR
    public MaterialEscolar(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS / SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoMaterial getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaterial estado) {
        this.estado = estado;
    }

    public int getDiasMantenimiento() {
        return diasMantenimiento;
    }

    public void setDiasMantenimiento(int diasMantenimiento) {
        this.diasMantenimiento = diasMantenimiento;
    }

    // MÉTODO PARA SABER SI EL MATERIAL ESTÁ DISPONIBLE PARA PRESTAR
    public boolean isDisponible() {
        return estado == EstadoMaterial.DISPONIBLE;
    }

    // TO STRING
    @Override
    public String toString() {
        String estadoTexto = "";
        switch (estado) {
            case DISPONIBLE:
                estadoTexto = "Disponible";
                break;
            case EN_PRESTAMO:
                estadoTexto = "En préstamo";
                break;
            case EN_MANTENIMIENTO:
                estadoTexto = "En mantenimiento (" + diasMantenimiento + " días restantes)";
                break;
        }
        return "Material: " + nombre + " | Estado: " + estadoTexto;
    }
}