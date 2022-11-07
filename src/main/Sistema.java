package main;

import java.util.ArrayList;
import java.util.List;

import busquedaDeProyectos.Busqueda;

public class Sistema {
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private Busqueda busquedaDeProyectos;
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public void addProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public void addCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	
}
