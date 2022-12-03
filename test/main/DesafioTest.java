package main;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restriccionDesafio.RestriccionDiaDeSemana;
import restriccionDesafio.RestriccionFinDeSemana;
import restriccionDesafio.RestriccionTemporal;
import java.time.LocalDate;
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
	void testConstructor() {
		assertEquals(desafio.getArea(),area);
		assertEquals(desafio.getRestricciones(),restricciones);
		assertEquals(desafio.getCantMuestrasParaBatir(),cantMuestrasParaBatir);
		assertEquals(desafio.getDificultad(),dificultad);
		assertEquals(desafio.getRecompensa(),recompensa);
	}

	@Test
	void testdesafioIniciaSinRestricciones() {
		assertTrue(desafio.getRestricciones().isEmpty());
	}
    @Test 
    void testSetearUnArea() {
    	desafio.setArea(area);
    	assertEquals(desafio.getArea(),area);
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
		when(area.estaEnLaCircunferencia(muestra.getCoordenadas())).thenReturn(true);
		assertTrue(desafio.muestraEstaEnElArea(muestra));
	}
	@Test
	void testmuestraNoPertenecienteAlArea() {
		when(area.estaEnLaCircunferencia(muestra.getCoordenadas())).thenReturn(false);
		assertFalse(desafio.muestraEstaEnElArea(muestra));
	}
	
	@Test
	void testMuestraCumpleLasRestricciones() {
		desafio.agregarRestriccionTemporal(new RestriccionFinDeSemana()); //setea restriccion de fin de semana
		when(muestra.getFecha()).thenReturn(LocalDate.of(2022, 11, 19));  //mockea para que retorne sabado
		assertTrue(desafio.muestraCumpleRestricciones(muestra));
	}
	
	@Test
	void testMuestraNoCumpleLasRestricciones() {
		desafio.agregarRestriccionTemporal(new RestriccionFinDeSemana()); //setea restriccion de fin de semana
		when(muestra.getFecha()).thenReturn(LocalDate.of(2022, 11, 16));  //mockea para que retorne miércoles
		assertFalse(desafio.muestraCumpleRestricciones(muestra));
	}

}
