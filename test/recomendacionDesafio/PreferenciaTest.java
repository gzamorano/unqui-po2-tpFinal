package recomendacionDesafio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreferenciaTest {
	Preferencia preferencia;
	Integer cantidadMuestras;
	Integer dificultad;
	Integer recompensa;
	
	@BeforeEach
	void setUp() throws Exception {
		cantidadMuestras = 15;
		dificultad = 3;
		recompensa = 50;
		preferencia = new Preferencia(cantidadMuestras, dificultad, recompensa);
	}

	@Test
	void testConstructor() {
		assertEquals(15, preferencia.getCantidadMuestras());
		assertEquals(3, preferencia.getDificultad());
		assertEquals(50, preferencia.getRecompensa());
	}

}
