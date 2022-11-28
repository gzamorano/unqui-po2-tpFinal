package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Proyecto;

class CoincidirTituloTest {
	
	String titulo;
	CoincidirTitulo filtroTitulo;
	Proyecto proyecto;

	@BeforeEach
	void setUp() throws Exception {
		titulo = "ética";
		filtroTitulo = new CoincidirTitulo(titulo);
		proyecto = mock(Proyecto.class);
	}

	@Test
	void testConstructor() {
		assertEquals(filtroTitulo.getTitulo(), "ética");
	}
	
	@Test
	void testUnProyectoCoincideConElTitulo() {
		when(proyecto.getNombre()).thenReturn(titulo);
		assertTrue(filtroTitulo.cumple(proyecto));
	}
	
	@Test
	void testUnProyecto_no_coincideConElTitulo() {
		when(proyecto.getNombre()).thenReturn("ñam fri frufi fali fru");
		assertFalse(filtroTitulo.cumple(proyecto));
	}

}
