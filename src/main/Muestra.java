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

	private void setCoordenadas(Point coordenadas) {
		this.coordenadas = coordenadas;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Muestra(Point coordenadas, LocalDate fecha, Usuario usuario) {
		this.setCoordenadas(coordenadas);
		this.setFecha(fecha);
		this.setUsuario(usuario);
	}
	
	public boolean aplicaParaUnDesafioActivo(DesafioDelUsuario desafioUsuario) {
		return desafioUsuario.estaAceptado() && desafioUsuario.getDesafio().muestraEstaEnElArea(this);
	}

}
