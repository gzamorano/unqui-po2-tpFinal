package restriccionDesafio;
import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResticcionDiaDeSemanaTest {
   RestriccionDiaDeSemana restriccionSemanal;
   LocalDate fecha1;
   LocalDate fecha2;
   
	@BeforeEach
	void setUp() throws Exception {
		restriccionSemanal = new RestriccionDiaDeSemana();
		fecha1 = LocalDate.of(2022, 11, 3);
		fecha2 = LocalDate.of(2022, 11, 5);
	}

	@Test
	void testesDiaDeSemanaValido() {
		assertTrue(restriccionSemanal.esDiaDeSemana(DayOfWeek.FRIDAY));
	}
	
	@Test
	void testesDiaDeSemanaInvalido() {
		assertFalse(restriccionSemanal.esDiaDeSemana(DayOfWeek.SATURDAY));
	}
	
	@Test
	void testesFechaValida() {
	    
		assertTrue(restriccionSemanal.cumple(fecha1));
	}
    
	@Test
	void testesFechaInvalida() {
	    
		assertFalse(restriccionSemanal.cumple(fecha2));
	}
}
