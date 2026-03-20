package prestamoescolar.modelo;

import java.util.ArrayList;

public class MaterialEscolar {
	private int codigo;
	private static int contadorCodigo=1;
	private Tipo tipo;
	private Estado estado;
	
	public static ArrayList<MaterialEscolar> materiales=new ArrayList<>();
	
	public MaterialEscolar(Tipo tipo,Estado estado){
		this.codigo=contadorCodigo;
		this.contadorCodigo++;
		this.tipo=tipo;
		this.estado=estado;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String toString() {
		return "El Material con codigo "+ codigo+" Es un "+tipo+" y su estado es "+estado;
	}
	

}
