package buscadorDeProyectos;

import java.util.List;

import main.*;

public class ExcluirCategoria extends Filtro {
	private List<Categoria> categorias;
	
	public ExcluirCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Categoria> getCategorias() {
		return this.categorias;
	}
	
	@Override
	public boolean cumple(Proyecto proyecto) {
		return this.getCategorias()
				   .stream()
				   .allMatch(categoria -> !proyecto.getCategorias().contains(categoria));
	}
	
}
