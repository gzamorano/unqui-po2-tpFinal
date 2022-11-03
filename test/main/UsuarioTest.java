package main;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.DesafioDelUsuario;
import main.Usuario;
import recomendacionDesafio.Preferencia;


class UsuarioTest {
	Usuario usuario; 	     
	Preferencia preferencia; 
	DesafioDelUsuario desafioDelUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		desafioDelUsuario = mock(DesafioDelUsuario.class);
	}

	
	// Testea que al crearse un usuario no tenga desafios asignados
	@Test
	void testCuandoUnUsuarioSeCreaComienzaSinDesafios() {
		assertTrue(usuario.getDesafiosDelUsuario().isEmpty());
	}
	
	// Testea la asignación de un desafio para un usuario 
	@Test
	void testUnUsuarioSeAdjudicaUnDesafioParaSiMismo() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		assertEquals(usuario.getDesafiosDelUsuario().get(0), desafioDelUsuario);
	}
	
	// Testea que un desafio completo es un desafio superado por un usuario
	@Test
	void testUnUsuarioCompletoUnDesafioConExito() {
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		assertTrue(usuario.superoElDesafio(desafioDelUsuario));
	}
	
	// Testea que un desafio incompleto no es un desafio superado por un usuario
	@Test
	void testUnUsuarioTodaviaNoCompletoUnDesafio() {
		when(desafioDelUsuario.estaCompleto()).thenReturn(false);
		assertFalse(usuario.superoElDesafio(desafioDelUsuario));
	}
	
	// Testea que un usuario pueda aceptar un desafio y al mismo le llega el mensaje de aceptación
	@Test
	void testUnUsuarioAceptaUnDesafio() {
		usuario.aceptarDesafio(desafioDelUsuario);
		verify(desafioDelUsuario).aceptarDesafio();
	}
	
	// Testea que se devuelvan correctamente los desafios completados por un usuario
	@Test
	void testCuandoUnUsuarioCompletaUnDesafioEsteFormaParteDeLosDesafiosCompletados() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		
		assertEquals(Arrays.asList(desafioDelUsuario), usuario.desafiosCompletados());
	}
	
	// Testea que un desafio incompleto no aparece en los desafios completados por el usuario
	@Test
	void testCuandoUnUsuarioAunNoCompletaUnDesafioEsteNoFormaParteDeLosDesafiosCompletados() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		when(desafioDelUsuario.estaCompleto()).thenReturn(false);
		
		assertTrue(usuario.desafiosCompletados().isEmpty());
	}
	
	// Testea que el porcentaje de completitud de un desafio sea correcto
	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeUnDesafioParticular() {
		when(desafioDelUsuario.porcentajeDeCompletitud()).thenReturn(50d);
		assertEquals(50, usuario.porcentajeDeCompletitud(desafioDelUsuario));
	}
	
	// Testea que el porcentaje de completitud de todos los desafios del usuario(sin contemplar los no aceptados) sea correcto
	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeTodosSusDesafios() {
		DesafioDelUsuario otroDesafioDelUsuario;
		otroDesafioDelUsuario = mock(DesafioDelUsuario.class);
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		usuario.añadirDesafioDelUsuario(otroDesafioDelUsuario);
		
		when(desafioDelUsuario.porcentajeDeCompletitud()).thenReturn(70d);
		when(otroDesafioDelUsuario.porcentajeDeCompletitud()).thenReturn(50d);
		
		assertEquals(60, usuario.porcentajeDeCompletitudGeneral());
	}
	
	
	
}
