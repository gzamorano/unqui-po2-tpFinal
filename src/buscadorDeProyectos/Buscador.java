package buscadorDeProyectos;

import java.util.List;

import main.Proyecto;

public class Buscador {
	private Filtro filtro;
	
	public Buscador(Filtro filtro) {
		this.filtro = filtro;
	}
	
	public Filtro getFiltro() {
		return this.filtro;
	}

	public List<Proyecto> buscarProyectosSegunFiltros(List<Proyecto> proyectos) {
		return this.getFiltro().filtrar(proyectos);
		
	}


}
