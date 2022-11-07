package recomendacionDesafio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.*;

class RecomendadorPorFavoritosTest {
	RecomendadorPorFavoritos recomendadorPorFavoritos;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	DesafioDelUsuario desafioDelUsuario1;
	DesafioDelUsuario desafioDelUsuario2;
	DesafioDelUsuario desafioDelUsuario3;
	
	Preferencia preferencia;
	Usuario usuario;
	Usuario otroUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		recomendadorPorFavoritos = new RecomendadorPorFavoritos();
		preferencia = mock(Preferencia.class);
		usuario = spy(new Usuario(preferencia));
		otroUsuario = mock(Usuario.class);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafioDelUsuario1 = spy(new DesafioDelUsuario(desafio1));
		desafioDelUsuario2 = spy(new DesafioDelUsuario(desafio2));
		desafioDelUsuario3 = spy(new DesafioDelUsuario(desafio3));
		
		when(desafio1.getCantMuestrasParaBatir()).thenReturn(15);
		when(desafio1.getDificultad()).thenReturn(2);
		when(desafio1.getRecompensa()).thenReturn(25);
		
		when(desafio2.getCantMuestrasParaBatir()).thenReturn(25);
		when(desafio2.getDificultad()).thenReturn(4);
		when(desafio2.getRecompensa()).thenReturn(19);
		
		when(desafio3.getCantMuestrasParaBatir()).thenReturn(10);
		when(desafio3.getDificultad()).thenReturn(4);
		when(desafio3.getRecompensa()).thenReturn(20);
	}

	// Testea que el nivel de similitud entre un par de desafios
	@Test
	void testNivelDeSimilitudEntreDesafios() {
		assertEquals(6, recomendadorPorFavoritos.similitudEntreDesafios(desafioDelUsuario1, desafioDelUsuario2));
	}
	
	// Testea los desafios ordenados por similitud en base a un desafio del usuario
	@Test
	void testDesafiosOrdenadosPorSimilitud() {
		List<DesafioDelUsuario> desafios = Arrays.asList(desafioDelUsuario2, desafioDelUsuario1, desafioDelUsuario3);
		
		assertEquals(Arrays.asList(desafioDelUsuario3, desafioDelUsuario1, desafioDelUsuario2)
					, recomendadorPorFavoritos.desafiosOrdenadosPorSimilitud(desafios, desafioDelUsuario3));
		
	}
	
	// Testea que se devuelva la cantidad deseada de desafios con mayor coincidencia de un usuario
	@Test
	void testDesafiosConMayorCoincidenciaParaUnUsuario() {
		when(preferencia.getCantidadMuestras()).thenReturn(10);
		when(preferencia.getDificultad()).thenReturn(3);
		when(preferencia.getRecompensa()).thenReturn(15);
		
		when(usuario.getDesafiosDelUsuario()).thenReturn(Arrays.asList(desafioDelUsuario1, desafioDelUsuario2, desafioDelUsuario3));
		
		when(desafioDelUsuario1.getCantidadMuestrasRecolectadas()).thenReturn(15);
		when(desafioDelUsuario2.getCantidadMuestrasRecolectadas()).thenReturn(25);
		when(desafioDelUsuario3.getCantidadMuestrasRecolectadas()).thenReturn(10);
		
		
		assertEquals(2, recomendadorPorFavoritos.desafiosConMayorCoincidencia(usuario, 2).size());
		assertEquals(Arrays.asList(desafioDelUsuario3, desafioDelUsuario1)
					, recomendadorPorFavoritos.desafiosConMayorCoincidencia(usuario, 2));
	}
	
	// Testea que a partir de todos los desafios de un usuario(en este caso 21 desafios) 5 de esos desafios
	// ordenados por similitud para ese usuario
	@Test
	void testRecomendacionDesafiosParaUnUsuario() {
		Desafio desafio4 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario4 = spy(new DesafioDelUsuario(desafio4));
		Desafio desafio5 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario5 = spy(new DesafioDelUsuario(desafio5));
		Desafio desafio6 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario6 = spy(new DesafioDelUsuario(desafio6));
		Desafio desafio7 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario7 = spy(new DesafioDelUsuario(desafio7));
		Desafio desafio8 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario8 = spy(new DesafioDelUsuario(desafio8));
		Desafio desafio9 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario9 = spy(new DesafioDelUsuario(desafio9));
		Desafio desafio10 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario10 = spy(new DesafioDelUsuario(desafio10));
		Desafio desafio11 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario11 = spy(new DesafioDelUsuario(desafio11));
		Desafio desafio12 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario12 = spy(new DesafioDelUsuario(desafio12));
		Desafio desafio13 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario13 = spy(new DesafioDelUsuario(desafio13));
		Desafio desafio14 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario14 = spy(new DesafioDelUsuario(desafio14));
		Desafio desafio15 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario15 = spy(new DesafioDelUsuario(desafio15));
		Desafio desafio16 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario16 = spy(new DesafioDelUsuario(desafio16));
		Desafio desafio17 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario17 = spy(new DesafioDelUsuario(desafio17));
		Desafio desafio18 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario18 = spy(new DesafioDelUsuario(desafio18));
		Desafio desafio19 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario19 = spy(new DesafioDelUsuario(desafio19));
		Desafio desafio20 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario20 = spy(new DesafioDelUsuario(desafio20));
		Desafio desafio21 = mock(Desafio.class);
		DesafioDelUsuario desafioDelUsuario21 = spy(new DesafioDelUsuario(desafio21));
		
		when(desafio4.getCantMuestrasParaBatir()).thenReturn(5);
		when(desafio4.getDificultad()).thenReturn(2);
		when(desafio4.getRecompensa()).thenReturn(15);
		
		when(desafio5.getCantMuestrasParaBatir()).thenReturn(50);
		when(desafio5.getDificultad()).thenReturn(5);
		when(desafio5.getRecompensa()).thenReturn(23);

		when(desafio6.getCantMuestrasParaBatir()).thenReturn(13);
		when(desafio6.getDificultad()).thenReturn(2);
		when(desafio6.getRecompensa()).thenReturn(17);
		
		when(desafio7.getCantMuestrasParaBatir()).thenReturn(12);
		when(desafio7.getDificultad()).thenReturn(3);
		when(desafio7.getRecompensa()).thenReturn(14);
		
		when(desafio8.getCantMuestrasParaBatir()).thenReturn(50);
		when(desafio8.getDificultad()).thenReturn(4);
		when(desafio8.getRecompensa()).thenReturn(35);
		
		when(desafio9.getCantMuestrasParaBatir()).thenReturn(5);
		when(desafio9.getDificultad()).thenReturn(2);
		when(desafio9.getRecompensa()).thenReturn(25);
		
		when(desafio10.getCantMuestrasParaBatir()).thenReturn(10);
		when(desafio10.getDificultad()).thenReturn(4);
		when(desafio10.getRecompensa()).thenReturn(22);
		
		when(desafio11.getCantMuestrasParaBatir()).thenReturn(6);
		when(desafio11.getDificultad()).thenReturn(1);
		when(desafio11.getRecompensa()).thenReturn(11);
		
		when(desafio12.getCantMuestrasParaBatir()).thenReturn(26);
		when(desafio12.getDificultad()).thenReturn(5);
		when(desafio12.getRecompensa()).thenReturn(24);
		
		when(desafio13.getCantMuestrasParaBatir()).thenReturn(10);
		when(desafio13.getDificultad()).thenReturn(4);
		when(desafio13.getRecompensa()).thenReturn(20);
		
		when(desafio14.getCantMuestrasParaBatir()).thenReturn(8);
		when(desafio14.getDificultad()).thenReturn(2);
		when(desafio14.getRecompensa()).thenReturn(8);
		
		when(desafio15.getCantMuestrasParaBatir()).thenReturn(14);
		when(desafio15.getDificultad()).thenReturn(3);
		when(desafio15.getRecompensa()).thenReturn(23);
		
		when(desafio16.getCantMuestrasParaBatir()).thenReturn(24);
		when(desafio16.getDificultad()).thenReturn(4);
		when(desafio16.getRecompensa()).thenReturn(22);
		
		when(desafio17.getCantMuestrasParaBatir()).thenReturn(11);
		when(desafio17.getDificultad()).thenReturn(2);
		when(desafio17.getRecompensa()).thenReturn(9);
		
		when(desafio18.getCantMuestrasParaBatir()).thenReturn(19);
		when(desafio18.getDificultad()).thenReturn(4);
		when(desafio18.getRecompensa()).thenReturn(29);
		
		when(desafio19.getCantMuestrasParaBatir()).thenReturn(25);
		when(desafio19.getDificultad()).thenReturn(5);
		when(desafio19.getRecompensa()).thenReturn(40);
		
		when(desafio20.getCantMuestrasParaBatir()).thenReturn(15);
		when(desafio20.getDificultad()).thenReturn(2);
		when(desafio20.getRecompensa()).thenReturn(20);
		
		when(desafio21.getCantMuestrasParaBatir()).thenReturn(7);
		when(desafio21.getDificultad()).thenReturn(3);
		when(desafio21.getRecompensa()).thenReturn(11);
		
		
		
		List<DesafioDelUsuario> desafios = Arrays.asList(desafioDelUsuario1,
														 desafioDelUsuario2,
														 desafioDelUsuario3,
														 desafioDelUsuario4,
														 desafioDelUsuario5,
														 desafioDelUsuario6,
														 desafioDelUsuario7,
														 desafioDelUsuario8,
														 desafioDelUsuario9,
														 desafioDelUsuario10,
														 desafioDelUsuario11,
														 desafioDelUsuario12,
														 desafioDelUsuario13,
														 desafioDelUsuario14,
														 desafioDelUsuario15,
														 desafioDelUsuario16,
														 desafioDelUsuario17,
														 desafioDelUsuario18,
														 desafioDelUsuario19,
														 desafioDelUsuario20,
														 desafioDelUsuario21);
		
		when(usuario.getDesafiosDelUsuario()).thenReturn(desafios);
		
		// Se igualan los valores de retorno de cada desafio y desafio del usuario para indicar que el desafio está completo
		when(desafioDelUsuario1.getCantidadMuestrasRecolectadas()).thenReturn(15);
		when(desafioDelUsuario2.getCantidadMuestrasRecolectadas()).thenReturn(25);
		when(desafioDelUsuario3.getCantidadMuestrasRecolectadas()).thenReturn(10);
		when(desafioDelUsuario4.getCantidadMuestrasRecolectadas()).thenReturn(5);
		when(desafioDelUsuario5.getCantidadMuestrasRecolectadas()).thenReturn(50);
		when(desafioDelUsuario6.getCantidadMuestrasRecolectadas()).thenReturn(13);
		when(desafioDelUsuario7.getCantidadMuestrasRecolectadas()).thenReturn(12);
		when(desafioDelUsuario8.getCantidadMuestrasRecolectadas()).thenReturn(50);
		when(desafioDelUsuario9.getCantidadMuestrasRecolectadas()).thenReturn(5);
		when(desafioDelUsuario10.getCantidadMuestrasRecolectadas()).thenReturn(10);
		when(desafioDelUsuario11.getCantidadMuestrasRecolectadas()).thenReturn(6);
		when(desafioDelUsuario12.getCantidadMuestrasRecolectadas()).thenReturn(26);
		when(desafioDelUsuario13.getCantidadMuestrasRecolectadas()).thenReturn(10);
		when(desafioDelUsuario14.getCantidadMuestrasRecolectadas()).thenReturn(8);
		when(desafioDelUsuario15.getCantidadMuestrasRecolectadas()).thenReturn(14);
		when(desafioDelUsuario16.getCantidadMuestrasRecolectadas()).thenReturn(24);
		when(desafioDelUsuario17.getCantidadMuestrasRecolectadas()).thenReturn(11);
		when(desafioDelUsuario18.getCantidadMuestrasRecolectadas()).thenReturn(19);
		when(desafioDelUsuario19.getCantidadMuestrasRecolectadas()).thenReturn(25);
		when(desafioDelUsuario20.getCantidadMuestrasRecolectadas()).thenReturn(15);
		when(desafioDelUsuario21.getCantidadMuestrasRecolectadas()).thenReturn(7);

		// Se aplican calificaciones 
		when(desafioDelUsuario1.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario2.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario3.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario4.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario5.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario6.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario7.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario8.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario9.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario10.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario11.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario12.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario13.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario14.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario15.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario16.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario17.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario18.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario19.getPuntuacion()).thenReturn(5);
		when(desafioDelUsuario20.getPuntuacion()).thenReturn(3);
		when(desafioDelUsuario21.getPuntuacion()).thenReturn(3);
		
		List<DesafioDelUsuario> desafiosEsperadosOrdenadosXSimilitud = Arrays.asList(desafioDelUsuario19, desafioDelUsuario12, desafioDelUsuario18, desafioDelUsuario16, desafioDelUsuario2);
		
		assertEquals(5, recomendadorPorFavoritos.recomendacionDesafiosPara(usuario).size());
		assertEquals(desafiosEsperadosOrdenadosXSimilitud, recomendadorPorFavoritos.recomendacionDesafiosPara(usuario));
	}
	
	
	
	
	
	
}
