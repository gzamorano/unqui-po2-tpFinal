package buscadorDeProyectos;

public abstract class ExpresionUnaria extends Filtro {
	private Filtro filtro;
	
	public ExpresionUnaria(Filtro filtro) {
		this.filtro = filtro;
	}
	
	public Filtro getFiltro() {
		return this.filtro;
	}
}
