package main;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restriccionDesafio.RestriccionDiaDeSemana;
import restriccionDesafio.RestriccionFinDeSemana;
import restriccionDesafio.RestriccionTemporal;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


class DesafioTest {
   Desafio desafio;
   Circulo area;
   List<RestriccionTemporal> restricciones;
   int cantMuestrasParaBatir;
   int dificultad;
   int recompensa;
   Muestra muestra;
   
	@BeforeEach
	void setUp() throws Exception {
		area = mock(Circulo.class);
		restricciones = new ArrayList<RestriccionTemporal>();
		desafio = new Desafio(area,restricciones,cantMuestrasParaBatir,dificultad,recompensa);
		muestra = mock(Muestra.class);
	}
	

	@Test
	void testdesafioIniciaSinRestricciones() {
		assertTrue(desafio.getRestricciones().isEmpty());
	}
	@Test 
	void testseAgregoRestriccionADesafio() {
		desafio.agregarRestriccionTemporal(new RestriccionFinDeSemana());
		assertEquals(restricciones.size(), 1);
	}
	@Test
	void testesRestriccionSimple() {
		desafio.agregarRestriccionTemporal(new RestriccionFinDeSemana());
		assertTrue(restricciones.size() == 1);
	}
	@Test
	void testesRestriccionCombinada() {
		desafio.agregarRestriccionTemporal(new RestriccionFinDeSemana());
		desafio.agregarRestriccionTemporal(new RestriccionDiaDeSemana());
		assertTrue(restricciones.size() >= 2);
	}
	
	@Test
	void testmuestraPertenecienteAlArea() {
		when(area.getCentro()).thenReturn(new Point(3,2));
		when(area.getRadio()).thenReturn(1.0);
        when(muestra.getCoordenadas()).thenReturn(new Point(3,3));
		assertTrue(desafio.muestraEstaEnElArea(muestra));
	}
	@Test
	void testmuestraNoPertenecienteAlArea() {
		when(area.getCentro()).thenReturn(new Point(3,2));
		when(area.getRadio()).thenReturn(1.0);
        when(muestra.getCoordenadas()).thenReturn(new Point(26,62));
		assertFalse(desafio.muestraEstaEnElArea(muestra));
	}
	
	

}
