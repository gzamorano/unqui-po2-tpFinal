package main;

public class Categoria {
	
	private String nombre;
	private String descripcion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria(String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}

}
