package main;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Point;

class CirculoTest {
	
	Circulo circulo;
	Point punto;
	Double radio;
	
	@BeforeEach
	void setUp() throws Exception {
		circulo = new Circulo(punto , radio);
		punto = new Point(3,2);
	}

	@Test
	void testperteneceACircunferencia() {
		Point coordenada = new Point(3,3);
		circulo.setCentro(punto);
		circulo.setRadio(1.0);
		assertTrue(circulo.estaEnLaCircunferencia(coordenada));
	}
   
	@Test 
	void testnoPerteneceACircunferencia() {
		Point coordenada = new Point(22,2);
		circulo.setCentro(punto);
		circulo.setRadio(1.0);
		assertFalse(circulo.estaEnLaCircunferencia(coordenada));
	}
}
