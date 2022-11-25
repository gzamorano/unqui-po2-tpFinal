package main;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recomendacionDesafio.*;


class UsuarioTest {
	Usuario usuario; 	     
	Preferencia preferencia; 
	DesafioDelUsuario desafioDelUsuario;
	DesafioDelUsuario otroDesafioDelUsuario;
	Desafio desafio;
	Desafio otroDesafio;
	DesafioDelUsuario desafioDelUsuarioSpy;
	Muestra muestra;
	Proyecto proyecto;
	
	@BeforeEach
	void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		proyecto = mock(Proyecto.class);
		usuario = new Usuario(preferencia);
		desafio = mock(Desafio.class);

		desafioDelUsuario = mock(DesafioDelUsuario.class);
		otroDesafioDelUsuario = mock(DesafioDelUsuario.class);
		desafioDelUsuarioSpy = spy(new DesafioDelUsuario(desafio));
		muestra =  mock(Muestra.class);
		
		
		usuario.addProyecto(proyecto);
		when(proyecto.getDesafios()).thenReturn(Arrays.asList(desafio, otroDesafio));
	}

	
	// Testea que al crearse un usuario no tenga desafios asignados
	@Test
	void testCuandoUnUsuarioSeCreaComienzaSinDesafios() {
		assertTrue(usuario.getDesafiosDelUsuario().isEmpty());
	}
	
	// Testea la asignación válida de un desafio para un usuario 
	@Test
	void testUnUsuarioSeAdjudicaUnDesafioParaSiMismo() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		assertEquals(usuario.getDesafiosDelUsuario().get(0), desafioDelUsuario);
	}
	
	// Testea que no se le asigna un desafio que no pertenece a alguno de los proyectos
	// en los que participa el usuario
	@Test
	void testNoSeAsignaUnDesafioQueNoFormaParteDeAlgunProyectoDelUsuario() {
		when(proyecto.getDesafios()).thenReturn(Arrays.asList());
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		assertTrue(usuario.getDesafiosDelUsuario().isEmpty());
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
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		usuario.añadirDesafioDelUsuario(otroDesafioDelUsuario);
		
		when(desafioDelUsuario.estaActivo()).thenReturn(true);
		when(otroDesafioDelUsuario.estaActivo()).thenReturn(true);
		when(desafioDelUsuario.porcentajeDeCompletitud()).thenReturn(70d);
		when(otroDesafioDelUsuario.porcentajeDeCompletitud()).thenReturn(50d);
		
		assertEquals(60, usuario.porcentajeDeCompletitudGeneral());
	}
	
	// Testea que se devuelvan los desafios sin aceptar de un usuario
	@Test
	void testUnUsuarioConoceSusDesafiosSinAceptar() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuarioSpy);
		
		assertEquals(Arrays.asList(desafioDelUsuarioSpy), usuario.desafiosSinAceptar());
	}
	
	// Test un usuario puede calificar un desafio
	@Test
	void testUnUsuarioPuedeCalificarUnDesafio() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		usuario.aceptarDesafio(desafioDelUsuario);
		
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		
		usuario.calificarDesafio(desafioDelUsuario, 4);
		
		verify(desafioDelUsuario).calificarDesafio(4);
	}
	
	
	// Testea que un usuario devuelva la mayor calificacion que le dió a un desafio
	@Test
	void testUnUsuarioConoceLaMayorCalificacionQueLeDioAUnDesafio() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		usuario.añadirDesafioDelUsuario(otroDesafioDelUsuario);
		usuario.aceptarDesafio(desafioDelUsuario);
		usuario.aceptarDesafio(otroDesafioDelUsuario);
		
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		when(otroDesafioDelUsuario.estaCompleto()).thenReturn(true);
		when(desafioDelUsuario.getPuntuacion()).thenReturn(5);
		when(otroDesafioDelUsuario.getPuntuacion()).thenReturn(3);
		
		assertEquals(5, usuario.mayorCalificacionParaUnDesafio());
	}
	
	// Testea que al elegir el usuario un desafio favorito, tal desafio es el que tiene la puntuación más alta con la 
	// que el usuario calificó un desafio
	@Test
	void testElDesafioFavoritoDeUnUsuarioEsUnoCompletadoYConMayorCalificacionQueHayaDado() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuario);
		usuario.añadirDesafioDelUsuario(otroDesafioDelUsuario);
		usuario.aceptarDesafio(desafioDelUsuario);
		usuario.aceptarDesafio(otroDesafioDelUsuario);
		
		when(desafioDelUsuario.estaCompleto()).thenReturn(true);
		when(otroDesafioDelUsuario.estaCompleto()).thenReturn(true);
		when(desafioDelUsuario.getPuntuacion()).thenReturn(3);
		when(otroDesafioDelUsuario.getPuntuacion()).thenReturn(5);
		
		assertEquals(otroDesafioDelUsuario, usuario.desafioFavorito());
	}
	
	
	// Testea que al buscar la coincidencia de desafios para el usuario dado, se hayan añadido los desafios
	// a los desafios de tal usuario
	@Test
	void testUnUsuarioBuscaMatchDeDesafiosYLosQueCoincidenSeAgreganEnSuListadoDeDesafios() {
		RecomendadorDesafio recomendadorPorPreferencias;
		recomendadorPorPreferencias = spy(new RecomendadorPorPreferencias());
		
		Desafio desafio1 = mock(Desafio.class);
		Desafio desafio2 = mock(Desafio.class);
		Desafio desafio3 = mock(Desafio.class);
		Desafio desafio4 = mock(Desafio.class);
		Desafio desafio5 = mock(Desafio.class);
		
		DesafioDelUsuario desafioDelUsuario1 = spy(new DesafioDelUsuario(desafio1));
		DesafioDelUsuario desafioDelUsuario2 = spy(new DesafioDelUsuario(desafio2));
		DesafioDelUsuario desafioDelUsuario3 = spy(new DesafioDelUsuario(desafio3));
		DesafioDelUsuario desafioDelUsuario4 = spy(new DesafioDelUsuario(desafio4));
		DesafioDelUsuario desafioDelUsuario5 = spy(new DesafioDelUsuario(desafio5));
		
		when(proyecto.getDesafios()).thenReturn(Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5));
		
		usuario.añadirDesafioDelUsuario(desafioDelUsuario1);
		usuario.añadirDesafioDelUsuario(desafioDelUsuario2);
		usuario.añadirDesafioDelUsuario(desafioDelUsuario3);
		usuario.añadirDesafioDelUsuario(desafioDelUsuario4);
		usuario.añadirDesafioDelUsuario(desafioDelUsuario5);
		
		usuario.setRecomendacionDesafio(recomendadorPorPreferencias);
		usuario.buscarMatchDesafios();
		
		verify(recomendadorPorPreferencias).recomendacionDesafiosPara(usuario);
		assertTrue(usuario.getDesafiosDelUsuario().containsAll(Arrays.asList(desafioDelUsuario1, desafioDelUsuario2, desafioDelUsuario3, desafioDelUsuario4, desafioDelUsuario5)));
	}
	
	//Testea que el usuario conoce los desafios que tiene activo
	@Test
	void testUnUsuarioConoceSusDesafiosActivos() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuarioSpy);
		usuario.aceptarDesafio(desafioDelUsuarioSpy);
		
		assertEquals(Arrays.asList(desafioDelUsuarioSpy), usuario.desafiosActivos());
	}
	
	
	// Testea que un usuario al crearse no tiene aún muestras recolectadas
	@Test
	void testCuandoSeCreaUnUsuarioNoTieneMuestrasRecolectadas() {
		assertTrue(usuario.getMuestrasRecolectadas().isEmpty());
	}
	
	// Testea que un usuario contabiliza una muestra que aplica para un desafio
	@Test
	void testUnUsuarioAgregaUnaMuestraYEstaSeContabilizaParaUnDesafioQueAplica() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuarioSpy);
		usuario.aceptarDesafio(desafioDelUsuarioSpy);

		when(muestra.aplicaParaUnDesafio(desafioDelUsuarioSpy)).thenReturn(true);
		
		usuario.añadirMuestra(muestra);
		
		verify(desafioDelUsuarioSpy).incrementarCantidadMuestrasRecolectadas();
		assertEquals(1, desafioDelUsuarioSpy.getCantidadMuestrasRecolectadas());
	}
	
	// Testea que un usuario no contabiliza una muestra que no aplica para un desafio
	@Test
	void testUnUsuarioAgregaUnaMuestraYEstaNoSeContabilizaParaUnDesafioQueNoAplica() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuarioSpy);
		usuario.aceptarDesafio(desafioDelUsuarioSpy);

		when(muestra.aplicaParaUnDesafio(desafioDelUsuarioSpy)).thenReturn(false);
		
		usuario.añadirMuestra(muestra);
		
		verify(desafioDelUsuarioSpy, never()).incrementarCantidadMuestrasRecolectadas();
		assertEquals(0, desafioDelUsuarioSpy.getCantidadMuestrasRecolectadas());
	}
	
	// Testea que un usuario no contabiliza una muestra que aplica para un desafio pero éste no fue aceptado por el usuario
	@Test
	void testUnUsuarioAgregaUnaMuestraYEstaNoSeContabilizaParaUnDesafioQueAplicaPeroNoEstaAceptado() {
		usuario.añadirDesafioDelUsuario(desafioDelUsuarioSpy);

		when(muestra.aplicaParaUnDesafio(desafioDelUsuarioSpy)).thenReturn(true);
		
		usuario.añadirMuestra(muestra);
		
		verify(desafioDelUsuarioSpy, never()).incrementarCantidadMuestrasRecolectadas();
		assertEquals(0, desafioDelUsuarioSpy.getCantidadMuestrasRecolectadas());
	}
	
}

