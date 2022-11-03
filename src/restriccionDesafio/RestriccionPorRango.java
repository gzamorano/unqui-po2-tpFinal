package restriccionDesafio;
import java.time.LocalDate;

public class RestriccionPorRango extends RestriccionTemporal {
	 LocalDate inicio;
	 LocalDate fin;
	
	public RestriccionPorRango(LocalDate _inicio, LocalDate _fin) {
		inicio = _inicio;
		fin = _fin;
	}
 
	public LocalDate getInicio() {
		return inicio;
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
		   fecha.isBefore(this.getFin()) || fecha.isEqual(this.getFin()));
    }
}