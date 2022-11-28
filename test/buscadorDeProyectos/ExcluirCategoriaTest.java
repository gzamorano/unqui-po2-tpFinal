package buscadorDeProyectos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Categoria;
import main.Proyecto;

class ExcluirCategoriaTest {
	
	ExcluirCategoria filtroCategoria;
	List<Categoria> categoriasFiltro = new ArrayList<Categoria>();
	Categoria categoria1;
	Categoria categoria2;
	Proyecto proyecto;
	List<Categoria> categoriasProyecto = new ArrayList<Categoria>();

	@BeforeEach
	void setUp() throws Exception {
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		categoriasFiltro.add(categoria1); //categorias que NO debe tener un proyecto para pasar el filtro
		filtroCategoria = new ExcluirCategoria(categoriasFiltro);
		proyecto = mock(Proyecto.class);
		categoriasProyecto.add(categoria2); //categorias que tiene el proyecto
		
		}

	@Test
	void testConstructor() {
		assertEquals(filtroCategoria.getCategorias(), categoriasFiltro);
	}
	
	@Test
	void testUnProyectoCumpleConElFiltro() {
		when(proyecto.getCategorias()).thenReturn(categoriasProyecto);
		assertTrue(filtroCategoria.cumple(proyecto));
	}
	
	@Test
	void testUnProyecto_no_cumpleConElFiltro() {
		categoriasProyecto.add(categoria1); //agrega la categoria que tiene el filtro por tanto no va a cumplir.
		when(proyecto.getCategorias()).thenReturn(categoriasProyecto);
		assertFalse(filtroCategoria.cumple(proyecto));
	}

}
