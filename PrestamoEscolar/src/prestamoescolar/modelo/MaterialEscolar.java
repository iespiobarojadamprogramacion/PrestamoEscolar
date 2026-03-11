package prestamoescolar.modelo;

public class MaterialEscolar {
	private int codigo;
	private static int contadorCodigo=1;
	private String nombre;
	private Tipo tipo;
	private Estado estado;
	
	MaterialEscolar(String nombre,Tipo tipo,Estado estado){
		this.codigo=contadorCodigo;
		this.contadorCodigo++;
		this.nombre=nombre;
		this.tipo=tipo;
		this.estado=estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "MaterialEscolar [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", estado=" + estado
				+ "]";
	}
	

}
