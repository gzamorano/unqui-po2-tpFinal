package restriccionDesafio;
import java.time.LocalDate;

public abstract class RestriccionTemporal {
	
	public abstract boolean cumple(LocalDate fecha);
}
