package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.Point;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	
	Usuario usuario;
	Muestra muestra1;
	Point coordenadas;
	LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		coordenadas = new Point(130,200);
		fecha = LocalDate.of(2020, 2, 6);
		muestra1 = new Muestra(coordenadas, fecha, usuario);
	}

	@Test
	void testConstructor() {
		fail("Not yet implemented");
	}

}
