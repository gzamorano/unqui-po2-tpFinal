package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Proyecto;

class ConjuncionFiltroTest {
	ConjuncionFiltro filtroConjuncion;
	Filtro filtro1;
	Filtro filtro2;
	Proyecto proyectox;
	

	@BeforeEach
	void setUp() throws Exception {
		filtro1 = mock(Filtro.class);
		filtro2 = mock(Filtro.class);
		proyectox = mock(Proyecto.class);
		filtroConjuncion = new ConjuncionFiltro(filtro1,filtro2);	
	}

	@Test
	// En este test se comprueba que se cumple la conjunción de filtros cuando ambos filtros cumplen la condición dada.
	void testCumpleLaConjuncionDeFiltros() {
		when(filtro1.cumple(proyectox)).thenReturn(true);
		when(filtro2.cumple(proyectox)).thenReturn(true);
		assertTrue(filtroConjuncion.cumple(proyectox));
	}
	
	@Test
	void testNoCumpleLaConjuncionDeFiltros() {
		when(filtro1.cumple(proyectox)).thenReturn(true);
		when(filtro2.cumple(proyectox)).thenReturn(false);
		assertFalse(filtroConjuncion.cumple(proyectox));
	}
	
	@Test
	// En este test se comprueba que al no cumplir uno de los dos filtros dados no se cumple la conjunción.
	void testNoCumpleLaConjuncionDeFiltros2() {
		when(filtro1.cumple(proyectox)).thenReturn(false);
		when(filtro2.cumple(proyectox)).thenReturn(true);
		assertFalse(filtroConjuncion.cumple(proyectox));
	}


}
