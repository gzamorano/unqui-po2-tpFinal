package restriccionDesafio;
import static org.junit.jupiter.api.Assertions.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionFinDeSemanaTest {
	 RestriccionFinDeSemana restriccionFinDeSemana;
	   LocalDate fecha1;
	   LocalDate fecha2;
	@BeforeEach
	void setUp() throws Exception {
		restriccionFinDeSemana = new RestriccionFinDeSemana();
		fecha1 = LocalDate.of(2022, 11, 3);
		fecha2 = LocalDate.of(2022, 11, 5);
	}

	@Test
	void testesDíaDeFinDeSemanaValido() {
		assertTrue(restriccionFinDeSemana.esFinDeSemana(DayOfWeek.SATURDAY));
	}
	@Test
	void testesDíaDeFinDeSemanaInvalido() {
		assertFalse(restriccionFinDeSemana.esFinDeSemana(DayOfWeek.FRIDAY));
	}
	@Test
	void testesFechaValida() {
		assertTrue(restriccionFinDeSemana.cumple(fecha2));
	}
	@Test
	void testesFechaInvalida() {
		assertFalse(restriccionFinDeSemana.cumple(fecha1));
	}
}
