package main;

import java.awt.Point;
import java.time.LocalDate;

public class Muestra {
	
	private Point coordenadas;
	private LocalDate fecha;
	private Usuario usuario;

	public Point getCoordenadas() {
		return coordenadas;
	}

	protected void setCoordenadas(Point coordenadas) {
		this.coordenadas = coordenadas;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	protected void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Muestra(Point coordenadas, LocalDate fecha, Usuario usuario) {
		this.setCoordenadas(coordenadas);
		this.setFecha(fecha);
		this.setUsuario(usuario);
	}
	
	public boolean aplicaParaUnDesafio(DesafioDelUsuario desafioUsuario) {
		return (desafioUsuario.getDesafio().muestraEstaEnElArea(this) 
						&& desafioUsuario.getDesafio().muestraCumpleRestricciones(this));
	}

}
