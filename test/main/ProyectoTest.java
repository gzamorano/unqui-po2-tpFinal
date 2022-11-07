package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectoTest {
	
	Proyecto proyecto;   //SUT
	Usuario usuario;     //DOC
	Muestra muestra;     //DOC
	Categoria categoria; //DOC
	Desafio desafio1;
	Desafio desafio2;
	List<Desafio> listaDesafios;

	@BeforeEach
	void setUp() throws Exception {
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		listaDesafios = new ArrayList<Desafio>();
		listaDesafios.add(desafio1);
		listaDesafios.add(desafio2);
		proyecto = new Proyecto("Arboles de Quilmes", "Registrar todos los árboles del partido de Quilmes", listaDesafios);
		muestra = mock(Muestra.class);
		usuario = mock(Usuario.class);
		categoria = mock(Categoria.class);
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
		assertEquals(proyecto.getCategorias().size(), 0);
	}
	
	@Test
	void testCuandoSeAgregaUnParticipanteLaCantidadAumenta() {
		proyecto.addParticipante(usuario);
		assertEquals(proyecto.getParticipantes().size(), 1);
	}
	
	@Test
	void testCuandoSeAgregaUnaMuestraLaCantidadAumenta() {
		proyecto.addMuestra(muestra);
		assertEquals(proyecto.getMuestras().size(), 1);
	}
	
	@Test
	void testCuandoSeAgregaUnaCategoriaLaCantidadAumenta() {
		proyecto.addCategoria(categoria);
		assertEquals(proyecto.getCategorias().size(), 1);
	}
	
	
}
