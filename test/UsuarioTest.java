import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recomendacionDesafio.Preferencia;


class UsuarioTest {
	Usuario usuario; 	     // SUT
	Preferencia preferencia; // DOC
	DesafioDelUsuario desafioDelUsuario; // DOC
	
	@BeforeEach
	void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		desafioDelUsuario = mock(DesafioDelUsuario.class);
	}

	@Test
	void testCuandoUnUsuarioSeCreaComienzaSinDesafios() {
		assertTrue(usuario.getDesafiosDelUsuario().isEmpty());
	}
	
	@Test
	void testUnUsuarioSeAdjudicaUnDesafioParaSiMismo() {
		usuario.addDesafioDelUsuario(desafioDelUsuario);
		assertEquals(usuario.getDesafiosDelUsuario().get(0), desafioDelUsuario);
	}
	
	@Test
	void testUnUsuarioCompletoUnDesafioConExito() {
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		assertTrue(usuario.superoElDesafio(desafioDelUsuario));
	}
	
	@Test
	void testUnUsuarioTodaviaNoCompletoUnDesafio() {
		when(desafioDelUsuario.estaCompleto()).thenReturn(false);
		assertFalse(usuario.superoElDesafio(desafioDelUsuario));
	}
	
	@Test
	void testUnUsuarioAceptaUnDesafio() {
		usuario.aceptarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario).aceptarDesafio();
	}
	
	@Test
	void testCuandoUnUsuarioCompletaUnDesafioEsteFormaParteDeLosDesafiosCompletados() {
		usuario.addDesafioDelUsuario(desafioDelUsuario);
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		
		assertEquals(Arrays.asList(desafioDelUsuario), usuario.desafiosCompletados());
	}
	
	@Test
	void testCuandoUnUsuarioAunNoCompletaUnDesafioEsteNoFormaParteDeLosDesafiosCompletados() {
		usuario.addDesafioDelUsuario(desafioDelUsuario);
		when(desafioDelUsuario.estaCompleto()).thenReturn(false);
		
		assertTrue(usuario.desafiosCompletados().isEmpty());
	}
	
	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeUnDesafioParticular() {
		when(desafioDelUsuario.porcentajeDeCompletitud()).thenReturn(50d);
		assertEquals(50f, usuario.porcentajeDeCompletitud(desafioDelUsuario));
	}
	
	
	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeTodosSusDesafios() {
		// setup
		DesafioDelUsuario otroDesafioDelUsuario;
		otroDesafioDelUsuario = mock(DesafioDelUsuario.class);
		usuario.addDesafioDelUsuario(desafioDelUsuario);
		usuario.addDesafioDelUsuario(otroDesafioDelUsuario);
		
		when(desafioDelUsuario.porcentajeDeCompletitud()).thenReturn(70d);
		when(otroDesafioDelUsuario.porcentajeDeCompletitud()).thenReturn(50d);
		
		assertEquals(60f, usuario.porcentajeDeCompletitudGeneral());
	}
	
	
}
