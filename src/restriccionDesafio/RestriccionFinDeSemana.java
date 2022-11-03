package restriccionDesafio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RestriccionFinDeSemana extends RestriccionTemporal{
	
    public RestriccionFinDeSemana() {}
	
	@Override
	public boolean cumple(LocalDate fecha) {
		return esFinDeSemana(fecha.getDayOfWeek());
	}
	
    public boolean esFinDeSemana(DayOfWeek dia) {
    	return(dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY);
    }
}
