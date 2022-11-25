package estadoDesafio;

import main.DesafioDelUsuario;

public abstract class EstadoDesafio {

	public abstract void aceptarDesafio(DesafioDelUsuario desafio);

	public abstract void superarDesafio(DesafioDelUsuario desafioDelUsuario);

	public abstract void incrementarCantidadMuestrasRecolectadas(DesafioDelUsuario desafioDelUsuario);

	public abstract void calificarDesafio(DesafioDelUsuario desafioDelUsuario, Integer puntuacion);

	public boolean estaActivo() {
		return false;
	}

	public boolean estaSinAceptar() {
		return false;
	}
	
}
