package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Proyecto;

class NegacionFiltroTest {
	NegacionFiltro negacionDefiltro;
	Filtro filtro;
    Proyecto proyectox;
	
	@BeforeEach
	void setUp() throws Exception {
		filtro = mock(Filtro.class);
		proyectox = mock(Proyecto.class);
		negacionDefiltro = new NegacionFiltro(filtro);
	}

	@Test
	// En este caso dado un filtro que cumple su condición se comprueba que al negarse no deberia cumplir la condición.
	void testCumpleLaNegación() {
		when(filtro.cumple(proyectox)).thenReturn(true);
		assertFalse(negacionDefiltro.cumple(proyectox));
	}
	
	@Test
	// En este caso dado un filtro que no cumple su condición se comprueba que al negarse deberia cumplir la condición.
	void testNoCumpleLaNegación() {
		when(filtro.cumple(proyectox)).thenReturn(false);
		assertTrue(negacionDefiltro.cumple(proyectox));
	}

}
