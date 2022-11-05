package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaTest {
	
	Categoria categoria;

	@BeforeEach
	void setUp() throws Exception {
		categoria = new Categoria("Biología", "Todo lo relacionado con Biología");
	}

	@Test
	void testConstructor() {
		assertEquals(categoria.getNombre(), "Biología");
		assertEquals(categoria.getDescripcion(), "Todo lo relacionado con Biología");
	}

}
