package restriccionDesafio;
import java.time.LocalDate;

public class RestriccionPorRango extends RestriccionTemporal {
	 private LocalDate inicio;
	 private LocalDate fin;
	
	public RestriccionPorRango(LocalDate _inicio, LocalDate _fin) {
		this.inicio = _inicio;
		this.fin = _fin;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public LocalDate getFin() {
		return fin;
	}

	@Override
	public boolean cumple(LocalDate fecha) {
		return estaEnElRango(fecha);
	}
	
	private boolean estaEnElRango(LocalDate fecha) {
	return(fecha.isAfter(this.getInicio()) || fecha.isEqual(this.getInicio()) &&
		   (fecha.isBefore(this.getFin()) || fecha.isEqual(this.getFin())));
    }
	
}