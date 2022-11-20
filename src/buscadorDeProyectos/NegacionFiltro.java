package buscadorDeProyectos;

import main.Proyecto;

public class NegacionFiltro extends ExpresionUnaria {

	public NegacionFiltro(Filtro filtro) {
		super(filtro);
	}

	@Override
	public boolean cumple(Proyecto proyecto) {
		return !this.getFiltro().cumple(proyecto);
	}

}
