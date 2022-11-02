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
		if(estaEnElRango(fecha)) {
			return true;
		}
		return false;
	}
	
	private boolean estaEnElRango(LocalDate fecha) {
		if(fecha.isAfter(this.getInicio()) || fecha.isEqual(this.getInicio()) &&
		   fecha.isBefore(this.getFin()) || fecha.isEqual(this.getFin())) {
			return true;
		}
		else { return false; }
	}
}
