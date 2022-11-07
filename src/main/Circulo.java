package main;
import java.awt.Point;

public class Circulo {
   private  Point centro;
   private  Double radio;
     
     public Circulo(Point _centro, Double _radio) {
    	 centro = _centro;
    	 radio = _radio;
     }

	public void setCentro(Point centro) {
		this.centro = centro;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	public Point getCentro() {
		return centro;
	}

	public Double getRadio() {
		return radio;
	}
     
    public boolean estaEnLaCircunferencia(Point coordenada) {
    	return Math.pow((coordenada.x - this.getCentro().x),2) +
    		   Math.pow((coordenada.y - this.getCentro().y),2) == this.getRadio();
    }
}
