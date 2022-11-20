package buscadorDeProyectos;


public abstract class ExpresionBinaria extends Filtro {
	private Filtro primerFiltro;
	private Filtro segundoFiltro;
	
	public ExpresionBinaria(Filtro primerFiltro, Filtro segundoFiltro) {
		this.primerFiltro = primerFiltro;
		this.segundoFiltro = segundoFiltro;
	}
	
	public Filtro getPrimerFiltro() {
		return this.primerFiltro;
	}
	
	public Filtro getSegundoFiltro() {
		return this.segundoFiltro;
	}
	
	
}
