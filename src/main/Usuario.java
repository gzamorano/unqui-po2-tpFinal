package main;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import estadoDesafio.*;
import recomendacionDesafio.*;

public class Usuario {
	private List<DesafioDelUsuario> desafiosDelUsuario = new ArrayList<DesafioDelUsuario>();
	private List<DesafioDelUsuario> desafiosRecomendados = new ArrayList<DesafioDelUsuario>();
	private List<Muestra> muestrasRecolectadas = new ArrayList<Muestra>();
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
	
	public void añadirDesafioDelUsuario(DesafioDelUsuario desafioDelUsuario) {
		this.getDesafiosDelUsuario().add(desafioDelUsuario);
	}
	
	public List<DesafioDelUsuario> getDesafiosRecomendados() {
		return this.desafiosRecomendados;
	}

	public RecomendadorDesafio getRecomendacionDesafio() {
		return this.recomendacionDesafio;
	}
	
	public void setRecomendacionDesafio(RecomendadorDesafio recomendador) {
		this.recomendacionDesafio = recomendador;
	}
	
	public void setDesafiosRecomendados(List<DesafioDelUsuario> desafiosARecomendar) {
		this.desafiosRecomendados = desafiosARecomendar;
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

	public List<DesafioDelUsuario> desafiosActivos(){
		return this.getDesafiosDelUsuario()
				.stream()
				.filter(desafio -> desafio.getEstado() instanceof DesafioAceptado)
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

	public Double porcentajeDeCompletitudGeneral() {
		List<DesafioDelUsuario> desafiosAceptadosYCompletados = this.getDesafiosDelUsuario()
											.stream()
											.filter(desafioUsuario -> !(desafioUsuario.getEstado() instanceof EsperandoAceptacion))
											.toList();
		
		Double porcentajeTotal = desafiosAceptadosYCompletados
											.stream()
											.mapToDouble(desafio -> desafio.porcentajeDeCompletitud())
											.sum();
		
		return  porcentajeTotal / desafiosAceptadosYCompletados.size();
	}

	public List<DesafioDelUsuario> desafiosSinAceptar() {
		return this.getDesafiosDelUsuario()
					.stream()
					.filter(desafio -> desafio.getEstado() instanceof EsperandoAceptacion)
					.toList();
	}


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

	public void buscarMatchDesafios() {
		this.setDesafiosRecomendados(this.getRecomendacionDesafio().recomendacionDesafiosPara(this));
	}



}
