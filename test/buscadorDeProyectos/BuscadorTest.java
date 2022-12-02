package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Proyecto;

class BuscadorTest {
	Buscador buscador;
	CoincidirTitulo filtro1;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;

	@BeforeEach
	void setUp() throws Exception {
		filtro1 = spy(new CoincidirTitulo("Proyecto Messi"));
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);
		buscador = new Buscador(filtro1);
		when(proyecto1.getNombre()).thenReturn("Proyecto Maradona");
		when(proyecto2.getNombre()).thenReturn("Proyecto Messi");
		when(proyecto3.getNombre()).thenReturn("Proyecto Messi");
		when(proyecto4.getNombre()).thenReturn("Proyecto Maradona");	
		
	}

	@Test
	void testConstructor() {
		assertEquals(buscador.getFiltro(), filtro1);
	}
	
	@Test
	void buscarProyectoSegunFiltro() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1,proyecto2,proyecto3,proyecto4);
		assertEquals(2,buscador.buscarProyectosSegunFiltros(proyectos).size());	
	}

}
