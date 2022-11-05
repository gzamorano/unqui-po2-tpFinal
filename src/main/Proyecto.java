package main;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private List<Usuario> participantes = new ArrayList<Usuario>();
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Desafio> desafios;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Desafio> getDesafios() {
		return desafios;
	}
	public void setDesafios(List<Desafio> desafios) {
		this.desafios = desafios;
	}
	
	public Proyecto(String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}
	public void addParticipante(Usuario usuario) {
		participantes.add(usuario);
		this.agregarDesafiosAUsuario(usuario);
	}
	private void agregarDesafiosAUsuario(Usuario usuario) {
		this.getDesafios().stream().forEach(desafio -> usuario.añadirDesafioDelUsuario(new DesafioDelUsuario(desafio)));
		
	}
	

}
