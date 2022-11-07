package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	Sistema sistema;
	Proyecto proyecto;
	Categoria categoria;

	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
		proyecto = mock(Proyecto.class);
		categoria = mock(Categoria.class);
	}
	
	@Test
	void testCuandoUnSistemaSeCreaNoTieneProyectos() {
		assertTrue(sistema.getProyectos().isEmpty());
	}
	
	@Test
	void testCuandoUnSistemaSeCreaNoTieneCategorias() {
		assertTrue(sistema.getCategorias().isEmpty());
	}

	@Test
	void testCuandoSeAgregaUnProyectoSuCantidadDeProyectosAumenta() {
		sistema.addProyecto(proyecto);
		assertEquals(sistema.getProyectos().size(), 1);
	}
	
	@Test
	void testCuandoSeAgregaUnCategoriaSuCantidadDeCategoriasAumenta() {
		sistema.addCategoria(categoria);
		assertEquals(sistema.getCategorias().size(), 1);
	}
	

}
