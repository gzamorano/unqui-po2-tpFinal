package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.Point;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	
	Usuario usuario;
	Muestra muestra;
	Point coordenadas;
	LocalDate fecha;
	DesafioDelUsuario desafioUsuario;
	Desafio desafio;

	@BeforeEach
	void setUp() throws Exception {
		coordenadas = new Point(130,200);
		fecha = LocalDate.of(2020, 2, 6);
		usuario = mock(Usuario.class);
		muestra = new Muestra(coordenadas, fecha, usuario);
		desafioUsuario = mock(DesafioDelUsuario.class);
		desafio = mock(Desafio.class);
	}

	@Test
	void testConstructor() {
		assertEquals(muestra.getCoordenadas().getX(), 130.00);
		assertEquals(muestra.getCoordenadas().getY(), 200.00);
		assertEquals(muestra.getFecha(), LocalDate.of(2020,2,6));
		assertEquals(muestra.getUsuario(), usuario);
	}
	
	@Test
	void testAplicaParaUnDesafio() {
		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		when(desafio.muestraEstaEnElArea(muestra)).thenReturn(true);
		when(desafio.muestraCumpleRestricciones(muestra)).thenReturn(true);
		
		assertTrue(muestra.aplicaParaUnDesafio(desafioUsuario));
	}
	
	@Test
	void testNoAplicaParaUnDesafio1() {
		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		when(desafio.muestraEstaEnElArea(muestra)).thenReturn(false);
		when(desafio.muestraCumpleRestricciones(muestra)).thenReturn(true);
		
		assertFalse(muestra.aplicaParaUnDesafio(desafioUsuario));
	}
	
	@Test
	void testNoAplicaParaUnDesafio2() {
		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		when(desafio.muestraEstaEnElArea(muestra)).thenReturn(true);
		when(desafio.muestraCumpleRestricciones(muestra)).thenReturn(false);
		
		assertFalse(muestra.aplicaParaUnDesafio(desafioUsuario));
	}

}
