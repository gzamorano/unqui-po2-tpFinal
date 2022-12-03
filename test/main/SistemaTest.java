package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buscadorDeProyectos.Buscador;
import buscadorDeProyectos.CoincidirTitulo;

class SistemaTest {
	
	Sistema sistema;
	Proyecto proyecto;
	Categoria categoria;
	Buscador buscador;
	CoincidirTitulo filtro;

	@BeforeEach
	void setUp() throws Exception {
		sistema = new Sistema();
		proyecto = mock(Proyecto.class);
		categoria = mock(Categoria.class);
		filtro = spy(new CoincidirTitulo("Proyecto Biotecnología"));
		buscador = spy(new Buscador(filtro));
		
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
	
	@Test
	void testBuscarProyectos_conProyectoCoincidente() {
		List<Proyecto> proyectosMock = new ArrayList<Proyecto>();
		proyectosMock.add(proyecto);
		when(proyecto.getNombre()).thenReturn("Proyecto Biotecnología");		
		
		sistema.addProyecto(proyecto);
		sistema.setBuscadorProyectos(buscador);
		
		sistema.buscarProyectos();
		verify(buscador).buscarProyectosSegunFiltros(sistema.getProyectos());
		assertEquals(sistema.buscarProyectos(), proyectosMock);
	}
	
	@Test
	void testBuscarProyectos_sinProyectoCoincidente() {
		when(proyecto.getNombre()).thenReturn("Proyecto Meteorología");
		
		sistema.addProyecto(proyecto);
		sistema.setBuscadorProyectos(buscador);
		
		sistema.buscarProyectos();
		verify(buscador).buscarProyectosSegunFiltros(sistema.getProyectos());
		assertEquals(sistema.buscarProyectos().size(), 0);
	}

}
