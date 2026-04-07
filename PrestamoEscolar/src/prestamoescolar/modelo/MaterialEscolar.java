package prestamoescolar.modelo;

import java.util.ArrayList;

/**
 * Clase MaterialEscolar. Representa un material que puede ser prestado dentro
 * del sistema. Cada material tiene un nombre, un estado y, en caso de
 * mantenimiento, un número de días restantes para volver a estar disponible.
 */

public class MaterialEscolar {

    private static int contadorId = 1;

    private int id;
    private Tipo_Material tipo;
    private Estado_Material estado;
    private int diasMantenimiento;

    public static ArrayList<MaterialEscolar> materiales = new ArrayList<>();

    // CONSTRUCTOR
    public MaterialEscolar(Tipo_Material tipo) {
        this.id = contadorId++;
        this.tipo = tipo;
        this.estado = Estado_Material.Disponible;
        this.diasMantenimiento = 0;
    }

    public int getId() {
        return id;
    }

    public Tipo_Material getTipo() {
        return tipo;
    }

    public Estado_Material getEstado() {
        return estado;
    }

    public int getDiasMantenimiento() {
        return diasMantenimiento;
    }

    public void setEstado(Estado_Material estado) {
        this.estado = estado;
    }

    public void setDiasMantenimiento(int dias) {
        this.diasMantenimiento = dias;
    }

    public boolean isDisponible() {
        return estado == Estado_Material.Disponible;
    }

    @Override
    public String toString() {

        String info = "ID: " + id +
                      " | Tipo: " + tipo +
                      " | Estado: " + estado;

        if (estado == Estado_Material.En_mantenimiento) {
            info += " | Dias mantenimiento: " + diasMantenimiento;
        }

        return info;
    }
}