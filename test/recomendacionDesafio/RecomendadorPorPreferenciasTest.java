package recomendacionDesafio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Desafio;
import main.DesafioDelUsuario;
import main.Usuario;

class RecomendadorPorPreferenciasTest {
	RecomendadorPorPreferencias recomendadorPorPreferencias;
	Preferencia preferencia;
	Usuario usuario;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	DesafioDelUsuario desafioDelUsuario1;
	DesafioDelUsuario desafioDelUsuario2;
	DesafioDelUsuario desafioDelUsuario3;
	DesafioDelUsuario desafioDelUsuario4;
	DesafioDelUsuario desafioDelUsuario5;
	
	@BeforeEach
	void setUp() throws Exception {
		recomendadorPorPreferencias = new RecomendadorPorPreferencias();
		preferencia = mock(Preferencia.class);
		usuario = spy(new Usuario(preferencia));
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafioDelUsuario1 = spy(new DesafioDelUsuario(desafio1));
		desafioDelUsuario2 = spy(new DesafioDelUsuario(desafio2));
		desafioDelUsuario3 = spy(new DesafioDelUsuario(desafio3));
		desafioDelUsuario4 = spy(new DesafioDelUsuario(desafio4));
		desafioDelUsuario5 = spy(new DesafioDelUsuario(desafio5));
		
		when(usuario.getPreferencia().getCantidadMuestras()).thenReturn(10);
		when(usuario.getPreferencia().getDificultad()).thenReturn(3);
		when(usuario.getPreferencia().getRecompensa()).thenReturn(15);
		
		// Desafio del usuario con nivel del coincidencia 10 con el usuario
		when(desafioDelUsuario1.getDesafio().getCantMuestrasParaBatir()).thenReturn(15);
		when(desafioDelUsuario1.getDesafio().getDificultad()).thenReturn(3);
		when(desafioDelUsuario1.getDesafio().getRecompensa()).thenReturn(10);
		
		// Desafio del usuario con nivel de coincidencia 2 con el usuario
		when(desafioDelUsuario2.getDesafio().getCantMuestrasParaBatir()).thenReturn(10);
		when(desafioDelUsuario2.getDesafio().getDificultad()).thenReturn(3);
		when(desafioDelUsuario2.getDesafio().getRecompensa()).thenReturn(13);
	}

	// Testea el nivel de coincidencia que tiene un usuario con un desafio
	@Test
	void testNivelDeCoincidenciaEntreUnUsuarioYUnDesafioDelUsuario() {
		assertEquals(10, recomendadorPorPreferencias.nivelDeCoincidencia(usuario, desafioDelUsuario1));
	}
	
	// Testea que devuelva los desafios ordenados según el nivel de coincidencia con el usuario
	@Test
	void testDesafiosOrdenadosSegunNivelDeCoincidencia() {
		when(usuario.getDesafiosDelUsuario()).thenReturn(Arrays.asList(desafioDelUsuario1, desafioDelUsuario2));
		
		assertEquals(Arrays.asList(desafioDelUsuario2, desafioDelUsuario1)
					, recomendadorPorPreferencias.desafiosOrdenadosSegunNivelDeCoincidencia(usuario));
	}
	
	
	@Test
	void testSeRecomiendanLosCincoDesafiosOrdenadosPorCoincidenciaParaUnUsuario() {
		// Desafio del usuario con nivel de coincidencia 8 con el usuario
		when(desafioDelUsuario3.getDesafio().getCantMuestrasParaBatir()).thenReturn(5);
		when(desafioDelUsuario3.getDesafio().getDificultad()).thenReturn(5);
		when(desafioDelUsuario3.getDesafio().getRecompensa()).thenReturn(16);
		
		// Desafio del usuario con nivel de coincidencia 15 con el usuario
		when(desafioDelUsuario4.getDesafio().getCantMuestrasParaBatir()).thenReturn(17);
		when(desafioDelUsuario4.getDesafio().getDificultad()).thenReturn(1);
		when(desafioDelUsuario4.getDesafio().getRecompensa()).thenReturn(9);
		
		// Desafio del usuario con nivel de coincidencia 5 con el usuario
		when(desafioDelUsuario5.getDesafio().getCantMuestrasParaBatir()).thenReturn(13);
		when(desafioDelUsuario5.getDesafio().getDificultad()).thenReturn(3);
		when(desafioDelUsuario5.getDesafio().getRecompensa()).thenReturn(13);
		
		List<DesafioDelUsuario> desafios = 
				Arrays.asList(desafioDelUsuario1, desafioDelUsuario2, desafioDelUsuario3, desafioDelUsuario4, desafioDelUsuario5);
		when(usuario.getDesafiosDelUsuario()).thenReturn(desafios);
		
		List<DesafioDelUsuario> desafiosOrd =
				Arrays.asList(desafioDelUsuario2, desafioDelUsuario5, desafioDelUsuario3, desafioDelUsuario1, desafioDelUsuario4);
		
		assertTrue(recomendadorPorPreferencias.recomendacionDesafiosPara(usuario).size() == 5);
     	assertEquals(desafiosOrd, recomendadorPorPreferencias.recomendacionDesafiosPara(usuario));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
