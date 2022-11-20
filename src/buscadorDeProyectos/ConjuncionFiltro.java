package buscadorDeProyectos;

import main.Proyecto;

public class ConjuncionFiltro extends ExpresionBinaria {

	public ConjuncionFiltro(Filtro primerFiltro, Filtro segundoFiltro) {
		super(primerFiltro, segundoFiltro);
	}

	@Override
	public boolean cumple(Proyecto proyecto) {
		return this.getPrimerFiltro().cumple(proyecto) && this.getSegundoFiltro().cumple(proyecto);
	}

}
