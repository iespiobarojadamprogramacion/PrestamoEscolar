
package prestamoescolar.modelo;

import java.util.ArrayList;

public class MaterialEscolar {

	/**
	 * Clase MaterialEscolar. Representa un material que puede ser prestado dentro
	 * del sistema. Cada material tiene un nombre, un estado y, en caso de
	 * mantenimiento, un número de días restantes para volver a estar disponible.
	 */

	private Tipo_Material tipo;
	private Estado_Material estado;
	private int diasMantenimiento;

	public static ArrayList<MaterialEscolar> materiales = new ArrayList<>();

	// CONSTRUCTOR
	public MaterialEscolar(Tipo_Material tipo) {
		this.tipo = tipo;
		this.estado = Estado_Material.Disponible;
		this.diasMantenimiento = 0;
	}

	// GETTERS
	public Tipo_Material getTipo() {
		return tipo;
	}

	public Estado_Material getEstado() {
		return estado;
	}

	public int getDiasMantenimiento() {
		return diasMantenimiento;
	}

	// SETTERS
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
		return "Material: " + tipo + " | Estado: " + estado;
	}

}