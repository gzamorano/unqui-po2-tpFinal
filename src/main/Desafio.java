package main;
import java.util.List;

import restriccionDesafio.RestriccionTemporal;

public class Desafio {
	private Circulo area;
	private List<RestriccionTemporal> restricciones;
	private int cantMuestrasParaBatir; // indica la cantidad de muestras necesarias para que este desafio sea completado.
	private int dificultad; // un num del 1 al 5, donde 1 es muy facil y 5 es muy dificil.
	private int recompensa; //un num que indica el puntaje obtenido como recompensa
	
	 public Desafio(Circulo _area, List<RestriccionTemporal> _restricciones, int _cantMuestrasParaBatir, int _dificultad, int _recompensa) {
		 area = _area;
		 restricciones = _restricciones;
		 cantMuestrasParaBatir = _cantMuestrasParaBatir;
		 dificultad = _dificultad;
		 recompensa = _recompensa;
	 }

	public Circulo getArea() {
		return area;
	}
	
	public void setArea(Circulo area) {
		this.area = area;
	}

	public List<RestriccionTemporal> getRestricciones() {
		return restricciones;
	}

	public int getCantMuestrasParaBatir() {
		return cantMuestrasParaBatir;
	}

	public int getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}
	 
	public void agregarRestriccionTemporal(RestriccionTemporal restriccion) {
		this.getRestricciones().add(restriccion);
	}
	
    public boolean muestraEstaEnElArea(Muestra muestra) {
    	return area.estaEnLaCircunferencia(muestra.getCoordenadas());
    }
    
}
