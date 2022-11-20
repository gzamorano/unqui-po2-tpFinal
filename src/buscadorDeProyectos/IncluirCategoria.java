package buscadorDeProyectos;

import java.util.List;

import main.*;

public class IncluirCategoria extends Filtro {
	private List<Categoria> categorias;
	
	public IncluirCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Categoria> getCategorias() {
		return this.categorias;
	}
	
	
	@Override
	public boolean cumple(Proyecto proyecto) {
		return this.getCategorias()
				   .stream()
				   .anyMatch(categoria -> proyecto.getCategorias().contains(categoria));
	}
	
	
}
