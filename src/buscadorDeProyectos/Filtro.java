package buscadorDeProyectos;

import java.util.List;

import main.Proyecto;

public abstract class Filtro {
	
	// Dado un listado de proyectos devuelve los proyectos que cumplan la condición del filtro
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		return 	proyectos
				.stream()
				.filter(proyecto -> this.cumple(proyecto))
				.toList();
	}
	
	// Indica si el proyecto dado cumple con la condición del filtro
	public abstract boolean cumple(Proyecto proyecto);
}
