package restriccionDesafio;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionPorRangoTest {
   RestriccionPorRango restriccionPorRango;
   LocalDate fecha1Rango;
   LocalDate fecha2Rango;
   LocalDate fechaValida;
   LocalDate fechaInvalida;
  
   
	@BeforeEach
	void setUp() throws Exception {
		restriccionPorRango = new RestriccionPorRango(fecha1Rango,fecha2Rango);
		fecha1Rango = LocalDate.of(2022,10,03);
		fecha2Rango = LocalDate.of(2022,11,03);
		fechaValida = LocalDate.of(2022,10,24);
		fechaInvalida = LocalDate.of(2010,12,23);
	}

	@Test
	void testfechaEstaEnMedioDelRango() {
		restriccionPorRango.setInicio(fecha1Rango);
		restriccionPorRango.setFin(fecha2Rango);
		
		assertTrue(restriccionPorRango.cumple(fechaValida));
	}
	@Test
	void testfechaEstaFueraDelRango() {
		restriccionPorRango.setInicio(fecha1Rango);
		restriccionPorRango.setFin(fecha2Rango);
		
		assertFalse(restriccionPorRango.cumple(fechaInvalida));
	}
	@Test
	void testfechaEsIgualAlPrimerRango() {
		restriccionPorRango.setInicio(fecha1Rango);
		restriccionPorRango.setFin(fecha2Rango);
		
		assertTrue(restriccionPorRango.cumple(fecha1Rango));
	}
	@Test
	void testfechaEsIgualAlSegundoRango() {
		restriccionPorRango.setInicio(fecha1Rango);
		restriccionPorRango.setFin(fecha2Rango);
		
		assertTrue(restriccionPorRango.cumple(fecha2Rango));
	}
}
