package estadoDesafio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DesafioDelUsuario;

class EsperandoAceptacionTest {
	EstadoDesafio estadoDesafio;
	DesafioDelUsuario desafioDelUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		estadoDesafio = new EsperandoAceptacion();
		desafioDelUsuario = mock(DesafioDelUsuario.class);
		// Para cada uno de los test se requiere que el estado sea DesafioCompletado
		when(desafioDelUsuario.getEstado()).thenReturn(estadoDesafio);
	}
	
	// Testea que un estado de desafio está sin aceptar
	@Test
	void testUnEstadoEsperandoAceptacionEstaSinAceptar() {
		assertTrue(estadoDesafio.estaSinAceptar());
	}
	

	// Testea que un estado de desafio sin aceptar al aceptar un desafio su estado cambia a aceptado
	@Test
	void testCuandoUnEstadoEsperandoSerAceptadoAceptaElDesafioDadoEsteCambiaAEstadoAceptado() {
		estadoDesafio.aceptarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario).setEstado(any(DesafioAceptado.class));
	}
	
	// Testea que un estado de desafio sin aceptar al calificar un desafio no se efectua la asignacion de puntuacion
	@Test
	void testCuandoUnEstadoEsperandoSerAceptadoCalificaUnDesafioNoSeAsignaLaPuntuacionAlDesafio() {
		Integer puntuacion = 3;
		estadoDesafio.calificarDesafio(desafioDelUsuario, puntuacion);
		verify(desafioDelUsuario, never()).setPuntuacion(puntuacion);
	}
	
	// Testea que al superar un desafio cuando el desafio está sin aceptar, el mismo no cambia su estado
	@Test
	void testCuandoUnDesafioEsperandoSerAceptadoSuperaUnDesafioNoTieneEfecto() {
		estadoDesafio.superarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario, never()).setEstado(any(EstadoDesafio.class));
	}
	
	// Testea que al incrementar la cantidad de muestras en un desafio con estado sin aceptar no se contabiliza 
	@Test
	void testCuandoUnEstadoEsperandoSerAceptadoIncrementaLaCantidadDeMuestrasNoSeContabiliza() {
		estadoDesafio.incrementarCantidadMuestrasRecolectadas(desafioDelUsuario);
		verify(desafioDelUsuario, never()).setCantidadMuestrasRecolectadas(any(Integer.class));
	}

}
