package main;

import java.util.ArrayList;
import java.util.List;

import buscadorDeProyectos.Buscador;

public class Sistema {
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private Buscador buscadorProyectos;

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public Buscador getBuscadorProyectos() {
		return this.buscadorProyectos;
	}
	
	public void setBuscadorProyectos(Buscador buscadorProyectos) {
		this.buscadorProyectos = buscadorProyectos;
	}
	
	public void addProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public void addCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	
	public List<Proyecto> buscarProyectos() {
		return this.getBuscadorProyectos().buscarProyectosSegunFiltros(this.getProyectos());
	}
	
}
