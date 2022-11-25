package main;

import estadoDesafio.*;

public class DesafioDelUsuario {
	private Integer cantidadMuestrasRecolectadas;
	private Integer puntuacion;
	private Desafio desafio;
	private EstadoDesafio estado; 
	
	public DesafioDelUsuario(Desafio desafio) {
		this.desafio = desafio;
		this.cantidadMuestrasRecolectadas = 0;
		this.puntuacion = 0;
		this.estado = new EsperandoAceptacion();
	}

	public EstadoDesafio getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoDesafio estado) {
		this.estado = estado;
	}

	public Integer getCantidadMuestrasRecolectadas() {
		return this.cantidadMuestrasRecolectadas;
	}
	
	public void incrementarCantidadMuestrasRecolectadas() {
		this.getEstado().incrementarCantidadMuestrasRecolectadas(this);
	}

	public void setCantidadMuestrasRecolectadas(int cantidad) {
		this.cantidadMuestrasRecolectadas = cantidad;
	}
	
	public Integer getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Desafio getDesafio() {
		return this.desafio;
	}

	public boolean estaCompleto() {
		return this.seAlcanzoLaCantidadDeMuestrasParaBatirElDesafio();
	}

	public void aceptarDesafio() {
		this.getEstado().aceptarDesafio(this);
	}

	// Devuelve el porcentaje de completitud del desafio del usuario
	public Double porcentajeDeCompletitud() {
		return (this.getCantidadMuestrasRecolectadas() * 100.0) / this.getDesafio().getCantMuestrasParaBatir();
	}

	public void comprobarCompletitud() {
		if(this.seAlcanzoLaCantidadDeMuestrasParaBatirElDesafio()) {
			this.getEstado().superarDesafio(this);
		}
	}

	public boolean seAlcanzoLaCantidadDeMuestrasParaBatirElDesafio() {
		return this.getCantidadMuestrasRecolectadas().equals(this.getDesafio().getCantMuestrasParaBatir());
	}

	// Se puntua a un desafio del 1 al 5
	public void calificarDesafio(Integer puntuacion) {
		this.getEstado().calificarDesafio(this, puntuacion);
	}

	public boolean estaActivo() {
		return this.getEstado().estaActivo();
	}

	public boolean estaSinAceptar() {
		return this.getEstado().estaSinAceptar();
	}



}
