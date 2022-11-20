package buscadorDeProyectos;

import main.Proyecto;

public class DisyuncionFiltro extends ExpresionBinaria {

	public DisyuncionFiltro(Filtro primerFiltro, Filtro segundoFiltro) {
		super(primerFiltro, segundoFiltro);
	}

	@Override
	public boolean cumple(Proyecto proyecto) {
		return this.getPrimerFiltro().cumple(proyecto) || this.getSegundoFiltro().cumple(proyecto);
	}
}
