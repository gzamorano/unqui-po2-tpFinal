package estadoDesafio;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DesafioDelUsuario;

class DesafioCompletadoTest {
	EstadoDesafio estadoDesafio; // SUT
	DesafioDelUsuario desafioDelUsuario; // DOC
	
	@BeforeEach
	void setUp() throws Exception {
		estadoDesafio = new DesafioCompletado();
		desafioDelUsuario = mock(DesafioDelUsuario.class);
		// Para cada uno de los test se requiere que el estado sea DesafioCompletado
		when(desafioDelUsuario.getEstado()).thenReturn(estadoDesafio);
	} 
	
	// Testea que un estado de desafio completado al aceptar el desafio no tiene efecto sobre el mismo
	@Test
	void testCuandoUnEstadoDeDesafioCompletadoAceptaUnDesafioDadoNoTieneEfecto() {
		estadoDesafio.aceptarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario, never()).setEstado(any(EstadoDesafio.class));
	}
	
	// Testea que un estado de desafio completado al calificar un desafio, se establece la puntuacion al mismo
	@Test
	void testCuandoUnEstadoDeDesafioCompletadoCalificaUnDesafioSeEstableceLaPuntuacionAlDesafio() {
		Integer puntuacion = 3;
		estadoDesafio.calificarDesafio(desafioDelUsuario, puntuacion);
		verify(desafioDelUsuario).setPuntuacion(3);
	}
	
	// Testea que al superar un desafio no tiene efecto cuando el estado del desafio es completado 
	@Test
	void testCuandoUnEstadoDeDesafioCompletadoSuperaUnDesafioElMismoNoCambiaSuEstado() {
		estadoDesafio.superarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario, never()).setEstado(any(EstadoDesafio.class));
	}
	
	// Testea que al incrementar la cantidad de muestras en un estado de desafio completado no la contabiliza para el mismo
	@Test
	void testCuandoUnEstadoDeDesafioCompletadoIncrementaLaCantidadDeMuestrasNoSeContabilizaParaElMismo() {
		estadoDesafio.incrementarCantidadMuestrasRecolectadas(desafioDelUsuario);
		verify(desafioDelUsuario, never()).setCantidadMuestrasRecolectadas(any(Integer.class));
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
