package main;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import recomendacionDesafio.*;

public class Usuario {
	private List<DesafioDelUsuario> desafiosDelUsuario = new ArrayList<DesafioDelUsuario>();
	private List<Muestra> muestrasRecolectadas = new ArrayList<Muestra>();
	private List<Proyecto> proyectosAbarcados = new ArrayList<Proyecto>();
	private RecomendadorDesafio recomendacionDesafio;
	private Preferencia preferencia;
	
	public Usuario(Preferencia preferencia) {
		this.preferencia = preferencia;
	}
	
	public Preferencia getPreferencia() {
		return this.preferencia;
	}

	public List<DesafioDelUsuario> getDesafiosDelUsuario() {
		return this.desafiosDelUsuario;
	}
	
	public List<Proyecto> getProyectosAbarcados() {
		return this.proyectosAbarcados;
	}
	
	public void addProyecto(Proyecto proyecto) {
		this.getProyectosAbarcados().add(proyecto);
	}
	
	// Corrección antes de añadir el desafio validar que el mismo pertenezca a algun proyecto en el que participa el usuario
	public void añadirDesafioDelUsuario(DesafioDelUsuario desafio) {
		if(this.desafioPerteneceAAlgunProyectoDelUsuario(desafio)) {
			this.getDesafiosDelUsuario().add(desafio);
		}
	}
	
	public boolean desafioPerteneceAAlgunProyectoDelUsuario(DesafioDelUsuario desafioDelUsuario) {
		return this.desafiosQueIntegranProyectosQueAbarcaElUsuario().contains(desafioDelUsuario.getDesafio());
	}
	
	// Devuelve el listado de todos los desafios que existen en los proyectos que participa el usuario
	public List<Desafio> desafiosQueIntegranProyectosQueAbarcaElUsuario() {
		List<Desafio> desafios = new ArrayList<Desafio>();
				
		this.getProyectosAbarcados()
			.stream()
			.forEach(proyecto -> desafios.addAll(proyecto.getDesafios()));
		
		return desafios;
	}

	public RecomendadorDesafio getRecomendacionDesafio() {
		return this.recomendacionDesafio;
	}
	
	public void setRecomendacionDesafio(RecomendadorDesafio recomendador) {
		this.recomendacionDesafio = recomendador;
	}
	
	public List<Muestra> getMuestrasRecolectadas() {
		return this.muestrasRecolectadas;
	}
	
	public void añadirMuestra(Muestra muestra) {
		this.getMuestrasRecolectadas().add(muestra);
		this.incrementarCantidadDeMuestrasEnDesafiosActivos(muestra);
	}
	
	private void incrementarCantidadDeMuestrasEnDesafiosActivos(Muestra muestra) {
		this.desafiosActivos()
			.stream()
			.forEach(desafio -> {if(muestra.aplicaParaUnDesafio(desafio)) desafio.incrementarCantidadMuestrasRecolectadas();});
	}

	// Corrección delegando al estado del desafio, en lugar de usar instanceOf
	public List<DesafioDelUsuario> desafiosActivos(){
		return this.getDesafiosDelUsuario()
				.stream()
				.filter(desafio -> desafio.estaActivo())
				.toList();	
	}

	public boolean superoElDesafio(DesafioDelUsuario desafioDelUsuario) {
		return desafioDelUsuario.estaCompleto();
	}

	public void aceptarDesafio(DesafioDelUsuario desafioDelUsuario) {
		desafioDelUsuario.aceptarDesafio();
	}

	public Double porcentajeDeCompletitud(DesafioDelUsuario desafioDelUsuario) {
		return desafioDelUsuario.porcentajeDeCompletitud();
	}

	public List<DesafioDelUsuario> desafiosCompletados() {
		return this.getDesafiosDelUsuario()
								.stream()
								.filter(desafioUsuario -> desafioUsuario.estaCompleto())
								.toList();
	}

	// Devuelve el porcentaje de completitud general del usuario, teniendo en cuenta los desafios
	// en curso y los completados.
	// Corrección delegando en el estado del desafio, en lugar de usar intanceOf.
	public Double porcentajeDeCompletitudGeneral() {
		List<DesafioDelUsuario> desafiosAceptadosYCompletados = this.getDesafiosDelUsuario()
											.stream()
											.filter(desafioUsuario -> desafioUsuario.estaActivo() || desafioUsuario.estaCompleto())
											.toList();

		Double porcentajeTotal = desafiosAceptadosYCompletados
											.stream()
											.mapToDouble(desafio -> desafio.porcentajeDeCompletitud())
											.sum();
		
		return  porcentajeTotal / desafiosAceptadosYCompletados.size();
	}

	// Correción delegando en el estado del usuario, en lugar de usar instanceOf.
	public List<DesafioDelUsuario> desafiosSinAceptar() {
		return this.getDesafiosDelUsuario()
					.stream()
					.filter(desafio -> desafio.estaSinAceptar())
					.toList();
	}

	// Devuelve el desafio favorito del usuario teniendo en cuenta los desafios que completó y la mayor calificación
	// con la que puntuó a tales desafios
	public DesafioDelUsuario desafioFavorito() {
		return this.desafiosCompletados()
				.stream()
				.filter(desafio -> desafio.getPuntuacion().equals(this.mayorCalificacionParaUnDesafio()) )
				.findAny().orElseThrow(NoSuchElementException::new);
	}

	public Integer mayorCalificacionParaUnDesafio() {
		return this.desafiosCompletados()
					.stream()
					.mapToInt(desafio -> desafio.getPuntuacion())
					.max().orElseThrow(NoSuchElementException::new);
	}

	public void calificarDesafio(DesafioDelUsuario desafioDelUsuario, int puntuacion) {
		desafioDelUsuario.calificarDesafio(puntuacion);
	}
	
	// Busca desafios a recomendar para el usuario de acuerdo con la recomendacion de desafio elegido por el mencionado.
	// Corrección eliminar el listado de desafios recomendados y colocarlos en el único listado de desafios del usuario.
	public void buscarMatchDesafios() {
		List<DesafioDelUsuario> desafiosRecomendados = this.recomendacionDesafio.recomendacionDesafiosPara(this);
		desafiosRecomendados.stream()
							.forEach(desafio -> this.añadirDesafioDelUsuario(new DesafioDelUsuario(desafio.getDesafio())));
	}

}
