package restriccionDesafio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RestriccionDiaDeSemana extends RestriccionTemporal{
	
	public RestriccionDiaDeSemana() {}

	@Override
	public boolean cumple(LocalDate fecha) {
		return esDiaDeSemana(fecha.getDayOfWeek());
	}
	
	public boolean esDiaDeSemana(DayOfWeek dia) {
   return (dia == DayOfWeek.MONDAY ||
		   dia == DayOfWeek.TUESDAY ||
		   dia == DayOfWeek.WEDNESDAY ||
		   dia == DayOfWeek.THURSDAY ||
		   dia == DayOfWeek.FRIDAY);
	}

}
