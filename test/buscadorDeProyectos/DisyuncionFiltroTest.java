package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Proyecto;

class DisyuncionFiltroTest {
   DisyuncionFiltro filtroDisyuncion;
   Filtro filtro1;
   Filtro filtro2;
   Proyecto proyectox;
   
	@BeforeEach
	void setUp() throws Exception {
		filtro1 = mock(Filtro.class);
		filtro2 = mock(Filtro.class);
		proyectox = mock(Proyecto.class);
		filtroDisyuncion = new DisyuncionFiltro(filtro1,filtro2);
	}

	@Test
	//En este test se comprueba que se cumple la disyunción con un caso donde se cumple una de las condiciones del filtro
	
	void testCumpleLaDisyuncionDeFiltros() {
		when(filtro1.cumple(proyectox)).thenReturn(false);
		when(filtro2.cumple(proyectox)).thenReturn(true);
		assertTrue(filtroDisyuncion.cumple(proyectox));
	}

	
	@Test
	void testCumpleLaDisyuncionDeFiltros2() {
		when(filtro1.cumple(proyectox)).thenReturn(true);
		when(filtro2.cumple(proyectox)).thenReturn(false);
		assertTrue(filtroDisyuncion.cumple(proyectox));
	}
	@Test
	//En este test se comprueba que al no cumplirse ninguna condición no se cumple la disyunción de filtros.
	void testNoCumpleLaDisyuncionDeFiltros() {
		when(filtro1.cumple(proyectox)).thenReturn(false);
		when(filtro2.cumple(proyectox)).thenReturn(false);
		assertFalse(filtroDisyuncion.cumple(proyectox));		
	}
}
