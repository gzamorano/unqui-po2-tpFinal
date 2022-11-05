package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectoTest {
	
	Proyecto proyecto; //SUT
	Usuario usuario;   //DOC
	Muestra muestra;   //DOC

	@BeforeEach
	void setUp() throws Exception {
		proyecto = new Proyecto("Arboles de Quilmes", "Registrar todos los árboles del partido de Quilmes");
		muestra = mock(Muestra.class);
		usuario = mock(Usuario.class);
	}

	@Test
	void testConstructor() {
		assertEquals(proyecto.getNombre(), "Arboles de Quilmes");
		assertEquals(proyecto.getDescripcion(), "Registrar todos los árboles del partido de Quilmes");
	}
	
	@Test
	void testCuandoUnProyectoSeCreaNoTieneParticipantes() {
		assertTrue(proyecto.getParticipantes().isEmpty());
	}
	
	@Test
	void testCuandoUnProyectoSeCreaNoTieneMuestras() {
		assertTrue(proyecto.getMuestras().isEmpty());
	}
	
	//falta test de desafios ************************************************************************
	
	@Test
	void testCuandoUnProyectoSeCreaNoTieneCategorias(){
		assertEquals(proyecto.getCategorias(), 0);
	}
	
	@Test
	void testCuandoSeAgregaUnParticipanteLaCantidadAumenta() {
		proyecto.addParticipante(usuario);
		assertEquals(proyecto.getParticipantes().size(), 1);
	}
}
