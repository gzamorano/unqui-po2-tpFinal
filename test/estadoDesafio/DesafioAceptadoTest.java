package estadoDesafio;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DesafioDelUsuario;

class DesafioAceptadoTest {
	EstadoDesafio estadoDesafio;
	DesafioDelUsuario desafioDelUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		//desafio = mock(Desafio.class);
		desafioDelUsuario = mock(DesafioDelUsuario.class);
		estadoDesafio = new DesafioAceptado();
		// Para cada uno de los test se requiere que el estado sea DesafioAceptado
		when(desafioDelUsuario.getEstado()).thenReturn(estadoDesafio);
	}
	
	// Testea que un estado de desafio aceptado al aceptar un desafio no tiene efecto sobre el mismo
		@Test
		void testCuandoUnEstadoAceptadoAceptaElDesafioDadoNoTieneEfecto() {
			estadoDesafio.aceptarDesafio(desafioDelUsuario);
			verify(desafioDelUsuario, never()).setEstado(any(EstadoDesafio.class));
		}
		
		// Testea que un estado de desafio aceptado al calificar un desafio no se efectua la asignacion de puntuacion
		@Test
		void testCuandoUnEstadoAceptadoCalificaUnDesafioNoSeAsignaLaPuntuacionAlDesafio() {
			Integer puntuacion = 3;
			estadoDesafio.calificarDesafio(desafioDelUsuario, puntuacion);
			verify(desafioDelUsuario, never()).setPuntuacion(puntuacion);
		}
		
		// Testea que al superar un desafio cuando el desafio está aceptado, el mismo pasa a estar completado
		@Test
		void testCuandoUnEstadoAceptadoSuperaUnDesafioDadoCambiaSuEstadoACompletado() {
			estadoDesafio.superarDesafio(desafioDelUsuario);
			verify(desafioDelUsuario).setEstado(any(DesafioCompletado.class));
		}
		
		// Testea que al incrementar la cantidad de muestras en un estado de desafio aceptado se contabiliza correctamente y
		// se comprueba la completitud del desafio
		@Test
		void testCuandoUnEstadoAceptadoIncrementaLaCantidadDeMuestrasDeUnDesafioSeContabilizaLaMuestraParaElMismo() {
			estadoDesafio.incrementarCantidadMuestrasRecolectadas(desafioDelUsuario);
			verify(desafioDelUsuario).setCantidadMuestrasRecolectadas(any(Integer.class));
			verify(desafioDelUsuario).comprobarCompletitud();
		}
		


}
