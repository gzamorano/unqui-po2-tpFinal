package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadoDesafio.DesafioAceptado;
import estadoDesafio.DesafioCompletado;
import estadoDesafio.EsperandoAceptacion;

class DesafioDelUsuarioTest {
	DesafioDelUsuario desafioDelUsuario; // SUT
	Desafio desafio; // DOC

	
	@BeforeEach
	void setUp() throws Exception {
		desafio = mock(Desafio.class);
		desafioDelUsuario = new DesafioDelUsuario(desafio);

	}

	// Testea que un desafio del usuario al crearse tenga por default el estado esperando ser aceptado
	@Test
	void testCuandoSeCreaUnDesafioDelUsuarioSuEstadoEsEsperandoSerAceptado() {
		assertTrue(desafioDelUsuario.getEstado() instanceof EsperandoAceptacion);
	}
	
	// Testea que al aceptar un desafio éste cambie su estado por aceptado
	@Test
	void testCuandoSeAceptaUnDesafioDelUsuarioRecienCreadoSuEstadoAhoraEsAceptado() {
		desafioDelUsuario.aceptarDesafio();
		assertTrue(desafioDelUsuario.getEstado() instanceof DesafioAceptado);
	}
	
	// Testea que el porcentaje de completitud de un desafio sea el correcto
	@Test
	void testUnDesafioDelUsuarioConoceSuPorcentajeDeCompletitud() {
		when(desafio.getCantMuestrasParaBatir()).thenReturn(10);
		desafioDelUsuario.aceptarDesafio();
		for(int i=0; i<6; i++) desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
		
		assertEquals(60, desafioDelUsuario.porcentajeDeCompletitud());
	}
	
	// Testea que un desafio se considera completo cuando llegó a recolectar la cantidad de muestras solicitadas
	@Test
	void testUnDesafioDelUsuarioSeConsideraCompletoAlRecoletarLaCantidadDeMuestrasDelDesafio() {
		when(desafio.getCantMuestrasParaBatir()).thenReturn(10);
		desafioDelUsuario.aceptarDesafio();
		for(int i=0; i<10; i++) desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
		
		assertTrue(desafioDelUsuario.estaCompleto());
		assertEquals(100, desafioDelUsuario.porcentajeDeCompletitud());
	}
	
	// Testea que al completar un desafio aceptado su estado sea completado
	@Test
	void testCuandoUnDesafioDelUsuarioAceptadoSeCompletaSuEstadoAhoraEsCompletado() {
		when(desafio.getCantMuestrasParaBatir()).thenReturn(10);
		desafioDelUsuario.aceptarDesafio();
		for(int i=0; i<10; i++) desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
		
		assertTrue(desafioDelUsuario.getEstado() instanceof DesafioCompletado);
	}
	
	// Testea que no se incrementa la cantidad de muestras recolectadas de un desafio del usuario que no fue aceptado
		@Test
		void testCuandoSeDeseaIncrementarLaCantidadDeMuestrasDeUnDesafioDelUsuarioEsperandoSerAceptadoNoSeContabiliza() {
			when(desafio.getCantMuestrasParaBatir()).thenReturn(10);
			desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
			
			assertEquals(0, desafioDelUsuario.getCantidadMuestrasRecolectadas());
		}

		// Testea que no se incrementa la cantidad de muestras recolectadas de un desafio del usuario que ya fue superado
		@Test
		void testCuandoSeDeseaIncrementarLaCantidadDeMuestrasDeUnDesafioDelUsuarioCompletadoNoSeContabiliza() {
			when(desafio.getCantMuestrasParaBatir()).thenReturn(10);
			desafioDelUsuario.aceptarDesafio();
			for(int i=0; i<10; i++) desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
			
			desafioDelUsuario.incrementarCantidadMuestrasRecolectadas(); 
			
			assertEquals(10, desafioDelUsuario.getCantidadMuestrasRecolectadas());
		}
		
		// Testea cuando se intenta calificar un desafio que aún no ha sido aceptado no tiene efecto
		@Test
		void testCuandoSeCalificaUnDesafioDeUsuarioQueEsperaSerAceptadoNoTieneEfecto() {
			desafioDelUsuario.calificarDesafio(4);
			
			assertEquals(0, desafioDelUsuario.getPuntuacion());
		}
		
		// Testea cuando se intenta calificar un desafio aceptado no tiene efecto
		@Test
		void testCuandoSeCalificaUnDesafioDeUsuarioAceptadoNoTieneEfecto() {
			desafioDelUsuario.aceptarDesafio();
			desafioDelUsuario.calificarDesafio(4);
			
			assertEquals(0, desafioDelUsuario.getPuntuacion());
		}
		
		// Testea cuando se intenta calificar un desafio completado no tiene efecto
		@Test
		void testCuandoSeCalificaUnDesafioDeUsuarioCompletadoNoTieneEfecto() {
			when(desafio.getCantMuestrasParaBatir()).thenReturn(5);
			desafioDelUsuario.aceptarDesafio();
			for(int i=0; i<5; i++) desafioDelUsuario.incrementarCantidadMuestrasRecolectadas();
			
			desafioDelUsuario.calificarDesafio(4);
			
			assertEquals(4, desafioDelUsuario.getPuntuacion());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
