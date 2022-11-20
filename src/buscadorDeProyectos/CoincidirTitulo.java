package buscadorDeProyectos;

import main.*;

public class CoincidirTitulo extends Filtro {
	private String titulo;
	
	public CoincidirTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	@Override
	public boolean cumple(Proyecto proyecto) {
		return this.getTitulo().contains(proyecto.getNombre());
	}

}
 