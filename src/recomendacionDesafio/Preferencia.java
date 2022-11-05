package recomendacionDesafio;

public class Preferencia {
	private Integer cantidadMuestras;
	private Integer dificultad;
	private Integer recompensa;
	
	public Preferencia(Integer cantidadMuestras, Integer dificultad, Integer recompensa) {
		this.cantidadMuestras = cantidadMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
	}

	public Integer getCantidadMuestras() {
		return this.cantidadMuestras;
	}

	public Integer getDificultad() {
		return this.dificultad;
	}

	public Integer getRecompensa() {
		return this.recompensa;
	}
}
